<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/2000/html">

<ul>
    <form action="/eleves" method="post">
    <#list users as user>
        <li>${user.id} - ${user.firstName} ${user.lastName} <button type="submit" value="${user.id}" name="delet">Suprimmer</button> </li>
    </#list>
    <input type="text" name="firstname" placeholder="Prenom">
    <input type="text" name="lastname" placeholder="Nom">
    <button type="submit" value="add" name="add">Ajouter</button>
    </form>
</ul>

</body>

</html>
