<html>
<head>
    <title>Order</title>
    <style type="text/css">
        body {
            font-family: 'Arial', sans-serif;
            margin: 20px;
        }

        h1 {
            color: #333;
        }

        ul {
        list-style: none;
        padding: 0;
        margin: 0;
        overflow: hidden; /* Clear floats */
        }

        div {
            float: left;
            margin-right: 10px; /* Dodajte prostor između divova po potrebi */
        }

        li {
            margin-bottom: 5px;
            padding: 8px;
            background-color: #f4f4f4;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <h1>Order</h1>

    <h2>Laundry Items</h2>
      <ul>
        <div>
            <#list laundry as l>
                <li>${l}</li>
            </#list>
        </div>
        <div>
            <#list laundryprice as sp>
                <li>${sp} din</li>
            </#list>
        </div>
    </ul>

    <h2>Service</h2>
    <ul>
        <div>
            <#list service as s>
                <li>${s}</li>
            </#list>
        </div>
        <div>
            <#list serviceprice as sp>
                <li>${sp} din</li>
            </#list>
        </div>
    </ul>

    <h2>Total price</h2>
    <ul>
        <li>${totalPrice} din</li>
    </ul>
</body>
</html>