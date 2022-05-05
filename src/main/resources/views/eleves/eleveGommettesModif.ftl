<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/2000/html">

<ul>
    <form action="/eleveGommettesModif" method="post">
    <#list gommettesEleve as gommette>
        <li>
            ${gommette.gommette.id} - ${gommette.gommette.couleur} - ${gommette.gommette.description}
                       
            <input type="text" name="motif-${gommette.id}" value="${gommette.motif}">  
            <input type="date" name= "date-${gommette.id}" value="${gommette.date}"> 
            
             - ${gommette.professeur.lastName}   
            <button type="submit" value="${gommette.id}" name="modif">Modifier</button>
        </li>
    </#list>
    
    <button type="submit" name="back" value="back">Retour</button>
    </form>
</ul>

</body>

</html>
