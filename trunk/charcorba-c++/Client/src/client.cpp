    // client.cc
    #include <iostream.h>
    #include <mico/naming.h>
    #include "CompteClient.h"

    int main(int argc, char* argv[])
    {
    // --- initialisation du bus et de l'adaptateur d'objets
    CORBA::ORB_var orb = CORBA::ORB_init ( argc, argv, "mico-local-orb" );

    // --- connexion au service de nommage
    CORBA::Object_var            ns = orb->resolve_initial_references ("NameService");
    CosNaming::NamingContext_var nc = CosNaming::NamingContext::_narrow (ns);

    // --- définition du chemin d'accès
    CosNaming::Name name;
    name.length (1);
    name[0].id   = CORBA::string_dup ("MonCompte");
    name[0].kind = CORBA::string_dup ("");

    // --- résolution du nom pour obtenir une référence sur MonCompte
    CORBA::Object_var obj    = nc->resolve (name);
    CompteClient_var  compte = CompteClient::_narrow( obj );

    // --- quelques opérations sur mon compte...
    compte->credit(1000000);
    cout << "solde: " << compte->solde() << endl;
    // --- ... super !

    return 0;
    }

