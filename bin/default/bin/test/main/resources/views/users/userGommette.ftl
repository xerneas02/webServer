<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/2000/html">
    <h1>${firstname} ${lastname}</h1>
    <ul>
        <form action="/eleveGommette/${firstname}-${lastname}" method="post">
        <#list gommettes as gommette>
            <li>${gommette.id} - ${gommette.couleur} ${user.description} <button type="submit" value="${gommette.id}" name="delet">Suprimmer</button> </li>
        </#list>
        </form>
    </ul>

</body>

</html>