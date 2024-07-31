document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("sales-form");
  form.addEventListener("submit", function (event) {
    event.preventDefault();

    // Get form data
    const item = document.getElementById("item").value;
    const quantity = document.getElementById("quantity").value;
    const pricePerUnit = document.getElementById("pricePerUnit").value;
    const totalPrice = document.getElementById("totalPrice").value;
    const date = document.getElementById("date").value;
    const customerName = document.getElementById("customerName").value;
    const customerEmail = document.getElementById("customerEmail").value;
    const paymentMethod = document.getElementById("paymentMethod").value;
    const discount = document.getElementById("discount").value;
    const productCategory = document.getElementById("productCategory").value;

    // Prepare the payload
    const payload = {
      item: item,
      quantity: quantity,
      pricePerUnit: pricePerUnit,
      totalPrice: totalPrice,
      date: date,
      customerName: customerName,
      customerEmail: customerEmail,
      paymentMethod: paymentMethod,
      discount: discount,
      productCategory: productCategory,
    };

    // Send POST request to the backend
    fetch("http://127.0.0.1:8081/api/sales/insert_sales", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        Accept: "application/json",
      },
      body: JSON.stringify(payload),
    })
      .then((response) => {
        if (!response.ok) {
          return response.json().then((errorData) => {
            throw new Error(errorData.message || "Something went wrong");
          });
        }
        return response.json();
      })
      .then((data) => {
        console.log("Success:", data);
        // Display success message to the user
        document.getElementById("message").innerText =
          "Sale inserted successfully!";
        document.getElementById("message").style.backgroundColor = "#4CAF50";
      })
      .catch((error) => {
        console.error("Error:", error);
        // Display error message to the user
        document.getElementById(
          "message"
        ).innerText = `Error: ${error.message}`;
        document.getElementById("message").style.backgroundColor = "#f44336";
      });
  });
});
