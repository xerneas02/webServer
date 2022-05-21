<#ftl encoding="utf-8">

<head> 
    <link rel='stylesheet' href='/css/reset.css'>
    <link rel='stylesheet' href='/css/eleveGommetteModif.css'> 
</head>
<body xmlns="http://www.w3.org/2000/html">
<ul>
    <div id="gommetteListe" class="scroll">
        <form action="/eleveGommettesModif" method="post">
            <#list gommettesEleve as gommette>
                <li>
                    <div class="blockGommette">
                        <div class="gommette ${gommette.gommette.couleur}">
                           <!--  ${gommette.gommette.id} - ${gommette.gommette.couleur} - --> ${gommette.gommette.description}
                        </div>

                        <div class="inputOption">  
                            <input type="text" name="motif-${gommette.id}" value="${gommette.motif}"> 
                        </div>
                        <div class="inputOption"> 
                            <input type="date" name= "date-${gommette.id}" value="${gommette.date}">
                        </div>
                        <div class="prof">
                            ${gommette.professeur.lastName} 
                        </div>
                        <div class="boutonOption">
                            <div class="modif">
                                <button type="submit" value="${gommette.id}" name="modif">Modifier</button>
                            </div>
                        </div>
                    </div>
                </li>
            </#list>
            <div class="boutonRetour">
                <div class="boutonOption">
                    <button type="submit" name="back" value="back">Retour</button>
                </div>
            </div>
        </form>
    </div>
</ul>
</body>
</html>
