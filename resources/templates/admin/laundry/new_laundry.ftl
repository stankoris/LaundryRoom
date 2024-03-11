<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Patient</title>
    <link href="https://cdn.jsdelivr.net/npm/suneditor@latest/dist/css/suneditor.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/style_for_new_and_edit.css">
</head>
<body>

    <header>
        <a href="/admin">Home</a>
    </header>
    
    <#if saveLaundry?has_content>
        <script>
            <#if saveLaundry == "true">
                alert("Laundry has been saved successfully!");
                window.location.href = "/admin";
            <#else>
                alert("There was an error saving laundry!");
            </#if>
        </script>
    </#if>

    <main>
        <form action="/admin/laundry/new_laundry" method="post" enctype="multypart/form-data">
            <div>
                <label for="name">Name</label>
                <input type="text" id="name" name="name" oninput="capitalizeAllLetters(this)" required />
            </div>

            <div>
                <label for="price">Price</label>
                <input type="text" id="price" name="price" required />
            </div>

            <div class="btn">
                <button type="submit">Save</button>
            </div>
        </form>
    </main>

    <script>
        function capitalizeAllLetters(input) {
        input.value = input.value.toUpperCase();
    }
    </script>
</body>
</html>
