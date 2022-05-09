<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/2000/html">

<ul>
    <form action="/gommettes" method="post">
    <#list gommettes as gommette>
        <li>
            ${gommette.id} - ${gommette.couleur} - ${gommette.description}
            <#if connexion == 1>
                <button type="submit" value="${gommette.id}" name="delete">Suprimmer</button> 
            </#if>
        </li>
    </#list>

    <#if connexion == 1>
        <select name="couleur">
            <option value="Blanc">Blanc</option>
            <option value="Rouge">Rouge</option>
        </select>
        <input type="text" name="description" placeholder="Description">
        <button type="submit" value="add" name="add">Ajouter</button>
    </#if>
    
    <button type="submit" value="back" name="back">Retour</button>
    </form>
</ul>

</body>

</html>
