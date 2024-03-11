<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Laundry</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/style_for_new_and_edit.css">
</head>
<body>

     <header>
        <a href="/admin">Home</a>
    </header>

    <#if updateService?has_content>
        <script>
            <#if updateService == "true">
                alert("Service has been updated successfully!");
            <#else>
                alert("There was an error updating service!");
            </#if>
        </script>
    </#if>

    <main>
        <form id="new_service_form" action="/admin/service/edit/${service.service_id}" method="post" enctype="multipart/form-data">
            <div>
                <label for="name">Name</label>
                <input type="text" id="name" name="name" value="${service.name}" oninput="capitalizeFirstLetter(this)" required />
            </div>

            <div>
                <label for="price">Price</label>
                <input type="text" id="price" name="price" value="${service.price}" required />
            </div>

            <div class="btn">
                <button type="submit">Update</button>
            </div>
        </form>
    </main>

    <script>
        const new_service_form = document.getElementById("new_service_form");
        new_service_form.onsubmit = () => {
            const html_content = editor.getContents(true);
        }

        function capitalizeFirstLetter(input) {
            input.value = input.value.charAt(0).toUpperCase() + input.value.slice(1);
        }
    </script>

</body>
</html>
