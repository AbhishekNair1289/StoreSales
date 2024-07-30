document
  .getElementById("sales-form")
  .addEventListener("submit", async function (event) {
    event.preventDefault();

    const item = document.getElementById("item").value;
    const quantity = document.getElementById("quantity").value;
    const price = document.getElementById("price").value;
    const date = document.getElementById("date").value;
    const customerName = document.getElementById("customerName").value;
    const customerEmail = document.getElementById("customerEmail").value;
    const paymentMethod = document.getElementById("paymentMethod").value;

    if (
      !item ||
      quantity <= 0 ||
      price <= 0 ||
      !date ||
      !customerName ||
      !customerEmail ||
      !paymentMethod
    ) {
      alert("Please fill out all fields correctly.");
      return;
    }

    const saleData = {
      item: item,
      quantity: quantity,
      price: price,
      date: date,
      customerName: customerName,
      customerEmail: customerEmail,
      paymentMethod: paymentMethod,
    };

    const response = await fetch("/api/sales/insert_sales", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(saleData),
    });

    if (response.ok) {
      alert("Sale data inserted successfully");
    } else {
      alert("Failed to insert sale data");
    }
  });
