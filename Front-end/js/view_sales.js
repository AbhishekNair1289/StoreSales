document.addEventListener("DOMContentLoaded", () => {
  const salesTable = document
    .getElementById("sales-table")
    .querySelector("tbody");
  const message = document.getElementById("message");
  const salesChart = document.getElementById("sales-chart").getContext("2d");

  // Function to fetch sales data
  const fetchSalesData = async () => {
    try {
      const response = await fetch("http://127.0.0.1:8081/api/sales/all");

      if (!response.ok) {
        throw new Error("Failed to fetch sales data");
      }

      const salesData = await response.json();
      displaySalesData(salesData);
      displaySalesChart(salesData);
    } catch (error) {
      console.error("Error:", error);
      message.innerText = `Error: ${error.message}`;
    }
  };

  // Function to display sales data in the table
  const displaySalesData = (salesData) => {
    salesTable.innerHTML = ""; // Clear existing data

    salesData.forEach((sale) => {
      const row = salesTable.insertRow();
      row.innerHTML = `
              <td>${sale.item}</td>
                <td>${sale.quantity}</td>
                <td>${sale.pricePerUnit.toFixed(2)}</td>
                <td>${sale.totalPrice.toFixed(2)}</td>
                <td>${sale.date}</td>
                <td>${sale.customerName}</td>
                <td>${sale.customerEmail}</td>
                <td>${sale.paymentMethod}</td>
                <td>${sale.discount.toFixed(2)}%</td>
                <td>${sale.productCategory}</td>
          `;
    });
  };

  const displaySalesChart = (salesData) => {
    const labels = salesData.map(sale => sale.date);
    const data = {
        labels: labels,
        datasets: [{
            label: 'Total Sales Amount',
            data: salesData.map(sale => sale.totalPrice),
            backgroundColor: 'rgba(75, 192, 192, 0.2)',
            borderColor: 'rgba(75, 192, 192, 1)',
            borderWidth: 1,
            tension: 0.4
        }]
    };

    const config = {
        type: 'line',
        data: data,
        options: {
            responsive: true,
            plugins: {
                legend: {
                    display: true,
                    position: 'top',
                },
                tooltip: {
                    mode: 'index',
                    intersect: false,
                }
            },
            scales: {
                x: {
                    type: 'time',
                    time: {
                        unit: 'day'
                    }
                },
                y: {
                    beginAtZero: true,
                    title: {
                        display: true,
                        text: 'Total Sales Amount ($)'
                    }
                }
            }
        }
    };

    new Chart(salesChart, config);
};

// Fetch sales data when the page loads
fetchSalesData();
});