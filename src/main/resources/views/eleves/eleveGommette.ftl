<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/2000/html">
    <h1>${firstname} ${lastname}</h1>
    <ul>
        <form action="/eleveGommette" method="post">
        <#list gommettesEleve as gommette>
            <li>
                ${gommette.gommette.id} - ${gommette.gommette.couleur} - ${gommette.gommette.description} - ${gommette.motif} - ${gommette.date} - ${gommette.professeur.lastName} 
                <#if connexion == 1>    
                    <button type="submit" value="${gommette.id}" name="delete">Suprimmer</button>
                </#if>
            </li>
        </#list>
        
        <#if connexion == 1>
            <select name="gommette">
                <#list gommettes as gommette>
                    <option value="${gommette.id}"> ${gommette.id} - ${gommette.couleur} - ${gommette.description} </option>
                </#list>
            </select>
            <input type="text" name="motif" placeholder="Motif">
            <button type="submit" value="add" name="add">Ajouter</button>
        </#if>

        <button type="submit" value="back" name="back">Retour</button>

        </form>
    </ul>

</body>

</html>