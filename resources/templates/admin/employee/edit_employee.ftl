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

    <#if updateEmployee?has_content>
        <script>
            <#if updateEmployee == "true">
                alert("Employee has been updated successfully!");
                window.location.href = "/admin/employee/all_employees"
            <#else>
                alert("There was an error updating employee!");
            </#if>
        </script>
    </#if>

    <main>
        <form id="new_employee_form" action="/admin/employee/edit/${employee.user_id}" method="post" enctype="multipart/form-data">
            <div>
                <label for="username">Userame</label>
                <input type="text" id="username" name="username" value="${employee.username}" required />
            </div>

            <div>
                <label for="password">Password</label>
                <input type="text" id="password" name="password" value="${employee.password}" required />
            </div>

             <div>
                <label for="user_type">User type (Admin/Employee)</label>
                <input type="text" id="user_type" name="user_type" value="${employee.user_type}" required />
            </div>

            <div class="btn">
                <button type="submit">Update</button>
            </div>
        </form>
    </main>

    <div style="display: flex; justify-content: center; font-size: 36px;">
        <a href="https://workat.tech/developer-tools/sha256-hash-generator" target="_blank"  style="text-decoration: none; color: black;" 
        onmouseover="this.style.color='blue'" onmouseout="this.style.color='black'">Ovde mozete generisati novi password</a>
    </div>


    <script>
        const new_employee_form = document.getElementById("new_employee_form");
        new_employee_form.onsubmit = () => {
            const html_content = editor.getContents(true);
        }
    </script>

</body>
</html>
