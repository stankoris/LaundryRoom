<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="/admin_dashboard.css">
</head>
<body>
<#if deleteLaundry?has_content>
    <script>
        <#if deleteLaundry == "true">
            alert("Laundry has been deleted successfully!")
        <#else>
            alert("There was an error deleteing laundry!")
        </#if>
    </script>
</#if>

<#if deleteService?has_content>
    <script>
        <#if deleteService == "true">
            alert("Service deleted!")
        <#else>
            alert("Service not deleted!")
        </#if>
    </script>
</#if>

<header>
    <a href="/admin/laundry/new_laundry">New laundry</a>
    <a href="/admin/service/new_service">New service</a>
    <a href="/admin/employee/new_employee">New employee</a>
    <a href="/admin/employee/all_employees">All employees</a>
    <a href="/login">Logout</a>
</header>

<main>
    <#if laundry?has_content>
        <table>
            <thead>
                <th colspan="5" class="laundry-heading">Laundry</th>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <#list laundry as l>
                    <tr>
                        <td>${l.laundry_id}</td>
                        <td>${l.name}</td>
                        <td>${l.price}</td>
                        <td><a href="/admin/laundry/edit/${l.laundry_id}">Edit</a></td>
                        <td><a class="delete_laundry_button" data-laundry="${l.name}" data-laundryid="${l.laundry_id}" href="#">Delete</a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
    <#else>
        <p>No laundry items available.</p>
    </#if>

    <div id="laundry_delete_modal">
        <p>Do you wish to delete <span id="span_name"></span>?</p>
        <a id="link_laundry_delete" href="#">Yes</a>
        <a href="#" onclick="this.parentElement.style.display='none'">No</a>
    </div>



<#if services?has_content>
        <table>
            <thead>
                <th colspan="5" class="laundry-heading">Service</th>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <#list services as service>
                    <tr>
                        <td>${service.service_id}</td>
                        <td>${service.name}</td>
                        <td>${service.price}</td>
                        <td><a href="/admin/service/edit/${service.service_id}">Edit</a></td>
                        <td><a class="delete_service_button" data-service="${service.name}" data-serviceid="${service.service_id}" href="#">Delete</a></td>
                    </tr>
                </#list>
            </tbody>
        </table>
    <#else>
        <p>No service items available.</p>
    </#if>

 <div id="service_delete_modal">
        <p>Do you wish to delete <span id="span_service_name"></span>?</p>
        <a id="link_service_delete" href="#">Yes</a>
        <a href="#" onclick="this.parentElement.style.display='none'">No</a>
    </div>
</main>

<script>

    const service_delete_modal = document.getElementById("service_delete_modal");
    const span_service_name = document.getElementById("span_service_name");
    const link_service_delete = document.getElementById("link_service_delete");
    const buttons_delete_service = document.getElementsByClassName("delete_service_button");

    for (let btn_delete of buttons_delete_service) {
        btn_delete.onclick = () => {
            const service_name = btn_delete.getAttribute("data-service");
            const service_id = btn_delete.getAttribute("data-serviceid");
            service_delete_modal.style.display = "block";
            span_service_name.innerHTML = service_name;
            link_service_delete.setAttribute("href", "/admin/service/delete/" + service_id);
        }
    }





    const laundry_delete_modal = document.getElementById("laundry_delete_modal");
    const span_name = document.getElementById("span_name");
    const link_laundry_delete = document.getElementById("link_laundry_delete");
    const buttons_delete_laundry = document.getElementsByClassName("delete_laundry_button");

    for (let btn_delete of buttons_delete_laundry) {
        btn_delete.onclick = () => {
            const laundry_name = btn_delete.getAttribute("data-laundry");
            const laundry_id = btn_delete.getAttribute("data-laundryid");
            laundry_delete_modal.style.display = "block";
            span_name.innerHTML = laundry_name;
            link_laundry_delete.setAttribute("href", "/admin/laundry/delete/" + laundry_id);
        }
    }
</script>

</body>
</html>
