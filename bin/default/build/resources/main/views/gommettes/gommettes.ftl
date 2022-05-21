<#ftl encoding="utf-8">

<head> 
    <link rel='stylesheet' href='/css/reset.css'>
    <link rel='stylesheet' href='/css/gommette.css'> 
</head>
<body xmlns="http://www.w3.org/2000/html">
<ul>
    <div id="gommetteListe" class="scroll">
        <form action="/gommettes" method="post">
        <#list gommettes as gommette>
            <li>
                <div class="blockGommette">
                    <div class="gommette ${gommette.couleur}">
                        <!-- ${gommette.id} - ${gommette.couleur} - --> ${gommette.description}
                    </div>
                    <#if connexion == 1>
                        <div class="boutonOption">
                            <div class="suppr">
                                <button type="submit" value="${gommette.id}" name="delete">Suprimmer</button>
                            </div>
                        </div>
                    </#if>
                </div>
            </li>
        </#list>
        <#if connexion == 1>
            <div class="blockGommette">
                <div class="boutonOption">
                    <select name="couleur">
                        <option value="Vert">Vert</option>
                        <option value="Blanc">Blanc</option>
                        <option value="Rouge">Rouge</option>
                    </select>
                </div>
                <div class="boutonOption">
                    <input type="text" name="description" placeholder="Description">
                </div>
                <div class="boutonOption">
                    <div class="ajout">
                        <button type="submit" value="add" name="add">Ajouter</button>
                    </div>
                </div>
                <div class="boutonOption">
                    <div class="modif">
                        <button type="submit" value="modif" name="modif">Modifier</button>
                    </div>
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
