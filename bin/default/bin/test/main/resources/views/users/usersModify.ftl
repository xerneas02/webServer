<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/2000/html">

<ul>
    <form action="/elevesModif" method="post">
    <#list users as user>
        <li>${user.id} - <input type="text" name="firstname-${user.id}" value="${user.firstName}"> <input type="text" name="lastname-${user.id}" value="${user.lastName}"> <button type="submit" value="${user.id}" name="modif">Modifier</button> </li>
    </#list>
    <button type="submit" name="back" value="back">Retour</button>
    </form>
</ul>

</body>

</html>
