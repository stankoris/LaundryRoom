<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All employees</title>
    <link rel="stylesheet" href="/all_employees.css">
</head>
<body>

<#if deleteEmployee?has_content>
    <script>
        <#if deleteEmployee == "true">
            alert("Employee has been deleted successfully!!")
        <#else>
            alert("There was an error deleteing employee!")
        </#if>
    </script>
</#if>

    <header>
        <a href="/admin">Home</a>
    </header>

    <#if employees?has_content>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Employee type</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <#list employees as employee>
                    <tr>
                        <td>${employee.user_id}</td>
                        <td>${employee.username}</td>
                        <td>${employee.password}</td>
                        <td>${employee.user_type}</td>
                        <td><a href="/admin/employee/edit/${employee.user_id}">Edit</a></td>
                        <td><a class="delete_employee_button" data-employee="${employee.username}" data-employeeid="${employee.user_id}" href="#">Delete</a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
    <#else>
        <p>No employees  found.</p>
    </#if>

        <div id="employee_delete_modal">
            <p>Do you wish to delete <span id="span_name"></span>?</p>
            <a id="link_employee_delete" href="#">Yes</a>
            <a href="#" onclick="this.parentElement.style.display='none'">No</a>
        </div>
    
    <script>
      
        const employee_delete_modal = document.getElementById("employee_delete_modal");
        const span_name = document.getElementById("span_name");
        const link_employee_delete = document.getElementById("link_employee_delete");
        const buttons_delete_employee = document.getElementsByClassName("delete_employee_button");

        for (let btn_delete of buttons_delete_employee) {
            btn_delete.onclick = () => {
                const employee_name = btn_delete.getAttribute("data-employee");
                const employee_id = btn_delete.getAttribute("data-employeeid");
                employee_delete_modal.style.display = "block";
                span_name.innerHTML = employee_name;
                link_employee_delete.setAttribute("href", "/admin/employee/delete/" + employee_id);
            }
        }

    </script>
</body>
</html>