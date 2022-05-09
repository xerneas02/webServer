<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/2000/html">

<ul>
    <form action="/gommettesModif" method="post">
    <#list gommettes as gommette>
        <li>
            ${gommette.id} -  
            <select name="couleur-${gommette.id}">
                <#if gommette.couleur = "Vert">
                    <option value="Vert" >Vert </option>
                    <option value="Blanc">Blanc</option>
                    <option value="Rouge">Rouge</option>
                <#elseif gommette.couleur = "Blanc">
                    <option value="Blanc">Blanc</option>
                    <option value="Vert" >Vert </option>
                    <option value="Rouge">Rouge</option>
                <#else>
                    <option value="Rouge">Rouge</option>
                    <option value="Vert" >Vert </option>
                    <option value="Blanc">Blanc</option>
                </#if> 
            </select>
            <input type="text" name="description-${gommette.id}" value="${gommette.description}"> 
            <button type="submit" value="${gommette.id}" name="modif">Valider</button> 
        </li>
    </#list>
    <button type="submit" name="back" value="back">Retour</button>
    </form>
</ul>

</body>

</html>


</html>
