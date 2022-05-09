<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/2000/html">

<ul>
    <form action="/elevesModif" method="post">
    <#list eleves as eleve>
        <li>
            ${eleve.id} - 
            <input type="text" name="firstname-${eleve.id}" value="${eleve.firstName}"> 
            <input type="text" name="lastname-${eleve.id}" value="${eleve.lastName}"> 
            <button type="submit" value="${eleve.id}" name="modif">Valider</button> 
        </li>
    </#list>
    <button type="submit" name="back" value="back">Retour</button>
    </form>
</ul>

</body>

</html>
