<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/2000/html">

<ul>
    <form action="/eleves" method="post">
        <#list users as user>
            <li>
                ${user.id} - ${user.firstName} ${user.lastName}
                <#if connexion == 1>
                    <button type="submit" value="${user.id}" name="delete">Suprimmer</button> 
                </#if>
                <button type="submit" value="${user.id}" name="gommettes">Gommettes</button> 
            </li>
        </#list>
        <#if connexion == 1>
            <input type="text" name="firstname" placeholder="Prenom">
            <input type="text" name="lastname" placeholder="Nom">
            <button type="submit" value="add" name="add">Ajouter</button>
            <button type="submit" value="modif" name="modif">Modifier</button>
        </#if>
        <button type="submit" value="back" name="back">Retour</button>
    </form>
</ul>

</body>

</html>
