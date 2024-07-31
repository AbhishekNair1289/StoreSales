document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("sales-form");
  const unitPriceInput = document.getElementById("pricePerUnit");
  const quantityInput = document.getElementById("quantity");
  const discountInput = document.getElementById("discount");
  const totalPriceInput = document.getElementById("totalPrice");
  const dateInput = document.getElementById("date");

  // Set today's date in the date input field
  const today = new Date().toISOString().split("T")[0];
  dateInput.value = today;

  // Calculate total price
  const calculateTotalPrice = () => {
    const unitPrice = parseFloat(unitPriceInput.value) || 0;
    const quantity = parseInt(quantityInput.value) || 0;
    const discount = parseFloat(discountInput.value) || 0;

    const totalPrice = unitPrice * quantity * (1 - discount / 100);
    totalPriceInput.value = totalPrice.toFixed(2);
  };

  // Event listeners to recalculate total price
  unitPriceInput.addEventListener("input", calculateTotalPrice);
  quantityInput.addEventListener("input", calculateTotalPrice);
  discountInput.addEventListener("input", calculateTotalPrice);

  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    const formData = new FormData(form);
    const salesData = Object.fromEntries(formData.entries());

    console.log("Sales Data:", salesData); // Debugging line to inspect sales data

    try {
      const response = await fetch(
        "http://127.0.0.1:8080/api/sales/insert_sales",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(salesData),
        }
      );

      if (!response.ok) {
        const errorDetails = await response.json();
        throw new Error(`Failed to insert sales data: ${errorDetails.message}`);
      }

      const result = await response.json();
      message.innerText = "Sale inserted successfully!";
      form.reset();
      message.classList.add("success");
      message.classList.remove("error");
    } catch (error) {
      console.error("Error:", error);
      message.innerText = `Error: ${error.message}`;
      message.classList.add("error");
      message.classList.remove("success");
    }
  });
});
