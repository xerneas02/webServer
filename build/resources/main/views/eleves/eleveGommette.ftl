<#ftl encoding="utf-8">

<head> 
    <link rel='stylesheet' href='/css/reset.css'>
    <link rel='stylesheet' href='/css/eleveGommette.css'>
</head>
<body xmlns="http://www.w3.org/2000/html">
    <div class="titre">
        <h1>${firstname} ${lastname}</h1>
    </div>
    <ul>
        <div id="eleveListe" class="scroll">
            <form action="/eleveGommettes" method="post">
                <#list gommettesEleve as gommette>
                    <li>
                        <div class="blockEleve">
                            <div class="eleve ${gommette.gommette.couleur}">
                                <!-- ${gommette.gommette.id} - ${gommette.gommette.couleur} - --> ${gommette.gommette.description} - ${gommette.motif} - ${gommette.date} - ${gommette.professeur.lastName} 
                            </div>
                            <#if connexion == 1>
                                <div class="boutonOption suppr">      
                                    <button type="submit" value="${gommette.id}" name="delete">Suprimmer</button>
                                </div>
                            </#if>  
                        </div>
                    </li>
                </#list>
                <#if connexion == 1>
                    <div class="blockEleve marginHaut">
                        <div class="boutonOption grand">
                            <select name="gommette">
                                <#list gommettes as gommette>
                                    <option value="${gommette.id}"> <!-- ${gommette.id} - ${gommette.couleur} - --> ${gommette.description} </option>
                                </#list>
                            </select>
                        </div>
                        <div class="boutonOption grand">
                            <input type="text" name="motif" placeholder="Motif">
                        </div>
                        <div class="boutonOption">
                            <input type="date" name="date">
                        </div>
                        <div class="boutonOption ajout">
                            <button type="submit" value="add" name="add">Ajouter</button>
                        </div>
                        <div class="boutonOption modif">
                            <button type="submit" value="modif" name="modif">Modifier</button>
                        </div>
                    </div>
                </#if>
                <div class="boutonRetour">
                    <div class="boutonOption">
                        <button type="submit" value="back" name="back">Retour</button>
                    </div>
                </div>
            </form>
        </div>
    </ul>
</body>
</html>