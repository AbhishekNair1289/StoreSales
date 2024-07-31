document.addEventListener("DOMContentLoaded", () => {
  const salesTable = document
    .getElementById("sales-table")
    .querySelector("tbody");
  const message = document.getElementById("message");
  const filterButton = document.getElementById("filter-button");

  filterButton.addEventListener("click", () => {
    const fromDate = document.getElementById("from-date").value;
    const toDate = document.getElementById("to-date").value;
    fetchSalesData(fromDate, toDate);
  });

  // Function to fetch sales data
  const fetchSalesData = async (fromDate = "", toDate = "") => {
    try {
      const queryParams = new URLSearchParams();
      if (fromDate) queryParams.append("fromDate", fromDate);
      if (toDate) queryParams.append("toDate", toDate);

      const response = await fetch(
        `http://127.0.0.1:8080/api/sales/all?${queryParams.toString()}`
      );

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
    salesTable.innerHTML = "";

    salesData.forEach((sale) => {
      const row = salesTable.insertRow();
      row.innerHTML = `
              <td>${sale.itemcode}</td>
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

  // Function to display sales chart
  function displaySalesChart(salesData) {
    const ctx = document.getElementById("sales-chart").getContext("2d");

    const labels = salesData.map((sale) => new Date(sale.date));
    const totalSales = salesData.map((sale) => sale.totalPrice);

    if (window.salesChart) {
      window.salesChart.destroy();
    }

    window.salesChart = new Chart(ctx, {
      type: "bar",
      data: {
        labels: labels,
        datasets: [
          {
            label: "Total Sales",
            data: totalSales,
            backgroundColor: "rgba(54, 162, 235, 0.2)",
            borderColor: "rgba(54, 162, 235, 1)",
            borderWidth: 1,
          },
        ],
      },
      options: {
        scales: {
          x: {
            type: "time",
            time: {
              unit: "day",
              tooltipFormat: "MM/dd/yyyy",
              displayFormats: {
                day: "MM/dd/yyyy",
              },
            },
            title: {
              display: true,
              text: "Date",
            },
          },
          y: {
            beginAtZero: true,
            title: {
              display: true,
              text: "Total Sales",
            },
          },
        },
      },
    });
  }

  fetchSalesData();
});
