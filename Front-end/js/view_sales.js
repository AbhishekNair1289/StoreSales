async function fetchMonthlySales() {
  const response = await fetch("/api/sales/monthly_sales");
  const salesData = await response.json();
  return salesData;
}

async function renderSalesChart() {
  const salesData = await fetchMonthlySales();
  const ctx = document.getElementById("sales-chart").getContext("2d");

  const labels = salesData.map((sale) => sale.date);
  const data = salesData.map((sale) => sale.price * sale.quantity);

  new Chart(ctx, {
    type: "bar",
    data: {
      labels: labels,
      datasets: [
        {
          label: "Monthly Sales",
          data: data,
          backgroundColor: "rgba(75,192,192,0.2)",
          borderColor: "rggba(75,192,192,1)",
          borderWidth: 1,
        },
      ],
    },
    options: {
      scales: {
        y: {
          beingAtZero: true,
        },
      },
    },
  });
}

renderSalesChart();
