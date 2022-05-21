<#ftl encoding="utf-8">

<head> 
    <link rel='stylesheet' href='/css/reset.css'>
    <link rel='stylesheet' href='/css/eleve.css'> 
</head>
<body xmlns="http://www.w3.org/2000/html">
<ul>
    <div id="eleveListe" class="scroll">
        <form action="/eleves" method="post">
            <#list eleves as eleve>
                <li>
                    <div class="blockEleve">
                        <div class="eleve">
                            <!-- ${eleve.id} - --> ${eleve.firstName} ${eleve.lastName}
                        </div>
                        <#if connexion == 1>   
                            <div class="boutonOption suppr">       
                                <button type="submit" value="${eleve.id}" name="delete">Suprimmer</button>
                            </div>
                        </#if>            
                        <div class="boutonOption gom">
                            <button type="submit" value="${eleve.id}" name="gommettes">Gommettes</button>
                        </div>
                    </div>
                </li>
            </#list>
            <#if connexion == 1>
                <div class="blockEleve">
                    <div class="boutonOption grand">
                        <input type="text" name="firstname" placeholder="Prenom">
                    </div>
                    <div class="boutonOption grand">
                        <input type="text" name="lastname" placeholder="Nom">
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
