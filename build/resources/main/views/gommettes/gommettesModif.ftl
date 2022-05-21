<#ftl encoding="utf-8">

<head> 
    <link rel='stylesheet' href='/css/reset.css'>
    <link rel='stylesheet' href='/css/gommetteModif.css'> 
</head>
<body xmlns="http://www.w3.org/2000/html">
<ul>
    <div id="gommetteListe" class="scroll">
        <form action="/gommettesModif" method="post">
        <#list gommettes as gommette>
            <li>
                <div class="blockGommette">
                    <!-- ${gommette.id} -  -->
                    <div class="boutonOption ${gommette.couleur}">
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
                    </div>
                    <div class="inputOption">
                        <input type="text" name="description-${gommette.id}" value="${gommette.description}">
                    </div>
                    <div class="boutonOption">
                        <div class="valid">
                            <button type="submit" value="${gommette.id}" name="modif">Valider</button>
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

