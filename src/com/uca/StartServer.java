package com.uca;

import com.uca.core.*;
import com.uca.dao._Initializer;
import com.uca.gui.*;
import com.uca.entity.*;
import java.util.ArrayList;

import static spark.Spark.*;

public class StartServer {
    static String eleveSelect = null;
    public static void main(String[] args) {
        //Configure Spark
        staticFiles.location("/static/");
        port(8081);


        _Initializer.Init();

        //Defining our routes

        //----  Definig gets  ----//
        get("/", (req, res) -> {
            /*
            Page d'acceuil avec 3 bouttons:
                -Connexion qui renvoie vers la page de connexion
                -Eleves qui renvoie vers la pages eleves
                -Gommettes qui renvoie vers la page gommettes
            */
            return IndexGUI.getIndex();
        });

        get("/login", (req, res) -> {
            /*
            Page de connexion contien 3 labels:
                -Prenom
                -Nom
                -Mot de passe
            Et 2 bouttons:
                -Connexion qui veriffie le nom, le prenom et le mot de passe et connecte la personne si ils sont valide
                -Retour qui renvoie vers la page d'acceuil
            */
            return ConexionGui.login();
        });

        get("/eleves", (req, res) -> {
            /*
            Contien la liste de tout les eleves.
            A côté de chaque élève il y a un boutton gommette qui renvoie vers la page gommettesEleve de l'eleve et
            si vous êtes connectez un boutton supprimer qui supprime l'eleve.
            Un boutton retour qui renvoie à la page d'acceuil.
            Et si vous êtes connécté 2 labels :
                -Prenom
                -Nom
            et 2 Bouttons :
                -Ajouter qui, si les 2 labels sont remplits, ajoute l'élève
                -Modifier qui renvoie vers la page eleveModif
            */
            boolean isConnected = req.session().attribute("lastname") != null;
            return EleveGUI.getAllEleves(isConnected);
        });

        get("/gommettes", (req, res) -> {
            /*
            Contiens la liste de toutes les gommettes,
            Si vous êtes connécté un boutton supprimer à côté de chaque gommettes pour la supprimer
            En bas de page un boutton retour qui renvoie vers la page d'acceuil.
            Et si vous êtes connectez une selection pour choisir entre rouge et blanc
            un label description
            et un boutton ajouter qui ajoute une gommette si tout les champs sont remplis.
            */
            boolean isConnected = req.session().attribute("lastname") != null;
            return GommetteGUI.getAllGommettes(isConnected);
        });

        get("/elevesModif", (req, res) -> {
            /*
            Si vous n'ête pas connécté renvoie vers la page eleves
            Si vous êtes connecté contient la liste des élèves avec le nom et prenom des élèves dans des labels
            pour pouvoir les modifier on peut ensuite valider la modification en appuyant sur le boutton Modifier
            à côté de chaque élèves.
            Et il y a boutton retour qui renvoir vers la page eleves.
            */
            if(req.session().attribute("lastname")== null)
            {
                res.redirect("/eleves");
                return null;
            }else{
                return ModifyEleveGUI.getAllEleves();
            }
        });

        get("/eleveGommettes", (req, res) -> {
            /*
            Contient la liste des gommettes d'un élèves avec leurs motif d'ajout, la date d'ajout et le nom du professeur qui la ajouter
            Si vous êtes connécté un boutton supprimer à côté des gommettes pour retirer la gommette à l'élève,
            une selection pour choisir une gommette, un label pour mettre un motif
            et un boutton ajouter qui si les champs sont remplis ajoutte une gommettes à l'élèves.
            */
            boolean isConnected = req.session().attribute("lastname") != null;
            if(eleveSelect == null){
                res.redirect("/eleves");
                return null;
            }else{
                Eleve eleve = EleveCore.getEleve(eleveSelect);
                return GommetteGUI.getAllEleveGommettes(eleve, isConnected);
            }
        });

        get("/eleveGommettesModif", (req, res) -> {
            /*
            Contient la liste des gommettes d'un élèves avec leurs motif d'ajout, la date d'ajout et le nom du professeur qui la ajouter
            Si vous êtes connécté un boutton supprimer à côté des gommettes pour retirer la gommette à l'élève,
            une selection pour choisir une gommette, un label pour mettre un motif
            et un boutton ajouter qui si les champs sont remplis ajoutte une gommettes à l'élèves.
            */
            boolean isConnected = req.session().attribute("lastname") != null;
            if(eleveSelect == null){
                res.redirect("/eleves");
                return null;
            }else{
                Eleve eleve = EleveCore.getEleve(eleveSelect);
                return ModifyEleveGommetteGUI.getAllEleveGommettes(eleve);
            }
        });

        get("/gommettesModif", (req, res) -> {
            /*
            Si vous n'ête pas connécté renvoie vers la page eleves
            Si vous êtes connecté contient la liste des élèves avec le nom et prenom des élèves dans des labels
            pour pouvoir les modifier on peut ensuite valider la modification en appuyant sur le boutton Modifier
            à côté de chaque élèves.
            Et il y a boutton retour qui renvoir vers la page eleves.
            */
            if(req.session().attribute("lastname")== null)
            {
                res.redirect("/gommettes");
                return null;
            }else{
                return ModifyGommetteGUI.getAllGommettes();
            }
        });

        //----  Definig posts  ----//
        post("/", (req, res) -> {
            String connexion = req.queryParams("Connexion");
            String eleves  = req.queryParams("Eleves");
            if(connexion != null){
                res.redirect("/login");
            }
            else if(eleves != null){
                res.redirect("/eleves");
            }
            else{
                res.redirect("/gommettes");
            }
            res.redirect("/");
            return null;
        });


        post("/login", (req, res) -> {
            String connexion = req.queryParams("connexion");
            if(connexion != null){
                String firstname = req.queryParams("firstname");
                String lastname  = req.queryParams("lastname");
                String password  = req.queryParams("password");
                int id = ProfesseurCore.checkLogin(lastname, firstname, password);
                if (id > -1)
                {
                    req.session(true);
                    req.session().attribute("firstname", firstname);
                    req.session().attribute("lastname" , lastname );
                    req.session().attribute("id"       , id       );
                    res.redirect("/");
                }
                else{
                    res.redirect("/login");
                }
            }else{
                res.redirect("/");
            }
            return null;
        });


        post("/eleves", (req, res) -> {
            String id = req.queryParams("delete");
            String gommette = req.queryParams("gommettes");
            String add = req.queryParams("add");
            String modif = req.queryParams("modif");
            if(id != null){
                id = removeSpaces(id);
                EleveCore.deleteEleve(id);
            }
            else if(gommette != null){
                gommette = removeSpaces(gommette);
                eleveSelect = gommette;
                res.redirect("/eleveGommettes");
            }
            else if(add != null){
                String firstName = req.queryParams("firstname");
                String lastName = req.queryParams("lastname");
                if(!firstName.equals("") && !lastName.equals(""))
                {
                    EleveCore.addEleve(firstName, lastName);
                }
            }
            else if(modif != null){
                res.redirect("/elevesModif");
            }
            else{
                res.redirect("/");
            }
            res.redirect("/eleves");
            return null;
        });


        post("/elevesModif", (req, res) -> {
            String id = req.queryParams("modif");
            if(id != null){
                String firstName = req.queryParams("firstname-"+id);
                String lastName = req.queryParams("lastname-"+id);     
                id = removeSpaces(id);
                if(!firstName.equals("") && !lastName.equals(""))
                {
                    EleveCore.updateEleve(id, firstName, lastName);
                }
            }else{
                res.redirect("/eleves");
            }
            res.redirect("/elevesModif");
            return null;
        });

        post("/eleveGommettes", (req, res) -> {
            String add              = req.queryParams("add");
            String idEleveGommette  = req.queryParams("delete");
            String modif            = req.queryParams("modif");
            String idEleve          = eleveSelect;
            if(add != null){
                String idGommette = req.queryParams("gommette");
                String motif      = req.queryParams("motif");
                String date       = req.queryParams("date");
                if(!motif.equals("") && !date.equals(""))
                {
                    String idProf = req.session().attribute("id") + "";
                    EleveGommetteCore.addEleveGommette(idEleve, idProf, idGommette, motif, date);
                }
            }
            else if(idEleveGommette != null){
                EleveGommetteCore.deleteEleveGommette(idEleveGommette);
            }
            else if(modif != null){
                res.redirect("/eleveGommettesModif");
            }
            else{
                res.redirect("/eleves");
            }
            res.redirect("/eleveGommettes");
            return null;
        });

        post("/gommettes", (req, res) -> {
            String add = req.queryParams("add");
            String idGommette  = req.queryParams("delete");
            String modif = req.queryParams("modif");
            if(add != null){
                String couleur     = req.queryParams("couleur");
                String description = req.queryParams("description");
                if(!couleur.equals("") && !description.equals(""))
                {
                    GommetteCore.addGommette(couleur, description);
                }
            }
            else if(idGommette != null){
                GommetteCore.deleteGommette(idGommette);
            }
            else if(modif != null){
                res.redirect("/gommettesModif");
            }
            else{
                res.redirect("/");
            }
            res.redirect("/gommettes");
            return null;
        });

        post("/gommettesModif", (req, res) -> {
            String id = req.queryParams("modif");
            if(id != null){
                String couleur = req.queryParams("couleur-"+id);
                String description = req.queryParams("description-"+id);     
                id = removeSpaces(id);
                if(!couleur.equals("") && !description.equals(""))
                {
                    GommetteCore.updateGommette(id, couleur, description);
                }
            } else{
                res.redirect("/gommettes");
            }
            res.redirect("/gommettesModif");
            return null;
        });

        post("/eleveGommettesModif", (req, res) -> {
            String id = req.queryParams("modif");
            if(id != null){
                String modif = req.queryParams("motif-"+id);
                String date  = req.queryParams( "date-"+id);    
                id = removeSpaces(id);
                System.out.println(modif + " " + date);
                if(!modif.equals("") && !date.equals(""))
                {   
                    EleveGommetteCore.updateEleveGommette(id, modif, date);
                }
            } else{
                res.redirect("/eleveGommettes");
            }
            res.redirect("/eleveGommettesModif");
            return null;
        });
    }

    private static String removeSpaces(String str){
        char[] strArray = str.toCharArray();
        String numbers = "0123456789";
        for  (int i = 0; i < strArray.length ;i++) {
            if(!numbers.contains(strArray[i] + "")){
                strArray[i] = ' ';
            }
        }
        str = new String(strArray);
        str = str.replaceAll(" ", "");
        return str;
    }
}