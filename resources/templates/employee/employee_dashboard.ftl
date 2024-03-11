<html >
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/employee_dashboard.css">
</head>
<body>

    <header>
        <a href="/login">Logout</a>
    </header>

    <div class="container">
        <h1>Order</h1>
        <form action="/order" method="post">
            <div class="laundry_lista">
                <#list  laundry as l>
                    <div class="laundry_container">
                        <input name="laundry" type="checkbox" value="${l.laundry_id}"> ${l.name} - ${l.price} din <br>
                    </div>
                </#list>
            </div>

             <h1>Service</h1>
            <#list services as service>
                <input name="service" type="checkbox" value="${service.service_id}"> ${service.name} - ${service.price} din
            </#list>

    
            <p id="totalPrice">Total price: 0 din</p>

            <p>
                <button type="submit">Create a bill</button>
            </p>
        </form>
    </div>

<script>
 document.addEventListener('DOMContentLoaded', function () {
    var checkboxes = document.querySelectorAll('input[type="checkbox"]');
    checkboxes.forEach(function (checkbox) {
        checkbox.addEventListener('change', function () {
            updateTotalPrice();
        });
    });

    function updateTotalPrice() {
        var totalPrice = 0;
        checkboxes.forEach(function (checkbox) {
            if (checkbox.checked) {
                var priceString = checkbox.nextSibling.nodeValue;
                var priceMatch = priceString.match(/(\d+(\.\d+)?)/);
                if (priceMatch) {
                    var price = parseFloat(priceMatch[1]);
                    if (!isNaN(price)) {
                        totalPrice += price;
                    }
                }
            }
        });
        document.getElementById('totalPrice').innerText = 'Ukupna cena: ' + totalPrice.toFixed(2) + ' din';
    }
});


</script>

</body>
</html>