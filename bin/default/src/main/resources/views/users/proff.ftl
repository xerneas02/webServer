<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/2000/html">

<ul>
    <#list users as user>
        <li>${user.id} - ${user.firstName} ${user.lastName} ${user.mdp}</li>
    </#list>
</ul>

</body>

</html>
