<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/2000/html">
    <h1>${firstname} ${lastname}</h1>
    <ul>
        <form action="/eleveGommette/${firstname}-${lastname}" method="post">
        <#list gommettes as gommette>
            <li>${gommette.id} - ${gommette.couleur} - ${gommette.description} - ${gommette.motif} - ${gommette.date} <button type="submit" value="${gommette.id}" name="delete">Suprimmer</button> </li>
        </#list>
        
        <select name="couleur">
            <option value="Blanc">Blanc</option>
            <option value="Rouge">Rouge</option>
        </select>
        <input type="text" name="description" placeholder="Description">
        <input type="text" name="motif" placeholder="Motif">
        <button type="submit" value="add" name="add">Ajouter</button>
        <button type="submit" value="back" name="back">Retour</button>

        </form>
    </ul>

</body>

</html>