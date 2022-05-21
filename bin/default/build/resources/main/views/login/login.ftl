<#ftl encoding="utf-8">

<head> 
    <link rel='stylesheet' href='/css/reset.css'>
    <link rel='stylesheet' href='/css/connexion.css'> 
</head>
<body xmlns="http://www.w3.org/2000/html">
<div class="backgroundFormulaire">
    <div class="pageFormulaire">
        <div><img src="/img/pokeball.png" alt="pokeball"></div>
        <p>Connexion<br>Professeur</p>
        <ul>
            <form action="/login" method="post">
                <div>
                    <input type="text" name="firstname" placeholder="Prenom">
                </div>
                <div>
                    <input type="text" name="lastname" placeholder="Nom">
                </div>
                <div>
                    <input type="password" name="password" placeholder="Mot de passe">
                </div>
                <div>
                    <button type="submit" value="connexion" name="connexion">Connexion</button>
                </div>
                <div>
                    <button type="submit" value="back" name="back">Retour</button>
                </div>
            </form>
        </ul>
    </div>
</div>

</body>
</html>