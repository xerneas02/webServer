<#ftl encoding="utf-8">

<head> 
    <link rel='stylesheet' href='/css/reset.css'>
    <link rel='stylesheet' href='/css/eleveModif.css'> 
</head>
<body xmlns="http://www.w3.org/2000/html">
<ul>
    <div id="gommetteListe" class="scroll">
        <form action="/elevesModif" method="post">
        <#list eleves as eleve>
            <li>
                <!-- ${eleve.id} - -->
                <div class="blockGommette">
                    <div class="inputOption">
                        <input type="text" name="firstname-${eleve.id}" value="${eleve.firstName}">
                    </div>
                    <div class="inputOption">
                        <input type="text" name="lastname-${eleve.id}" value="${eleve.lastName}">
                    </div>
                    <div class="boutonOption">
                        <div class="valid">
                            <button type="submit" value="${eleve.id}" name="modif">Valider</button>
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
