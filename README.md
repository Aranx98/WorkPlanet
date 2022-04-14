# WorkPlanet

Den här sidan är en plats där arbetsgivare hittar potentiella anställda till deras företag och uppdrag.

Det som gör att denna sidan sticker ut en del tillskillnad från andra, är att du som söker ett jobb kan skapa din profil, ladda upp cv, personligt brev och 
helt enkelt marknadsföra dig själv i din valda branch.

Hit kommer arbtesgivare för att hitta allt ifrån nyeximinerade till specialister inom sitt yrke. 

Vi började med att lägga till en JobViewLayout där man kan se själva utseendet på jobbet. 

Vi har ManagePostView och jobForm för att hantera sitt upplägg angående sin profil och det jobb man söker. JobForm är ett jobbformulär där man skriver in 
sina personliga uppgifter som namn, efternamn, email och annan viktig information.

Efter att vi har hårdkodat två användare så la vi till H2, Crud. Login och säkerhet.
De här två användarna  är mer för att visa som exempel på hur de användarnas jobbkort ser ut. 
Vi la även till en delete ikon i form av en soptunna för att enkelt ta bort. 
Vi har logga in och logga ut högst upp till höger så man vet om man som användare eller arbetsgivare är inloggad. 

ManageJobView la vi till hädanefter och på så sätt kan vi hantera, förändra, ta bort och lägga till jobbkorten. 
Vi har kopplat våran CRUD till denna klassen bland annat.

För att köra WorkPlanet;

1. Kör koden i IntelliJ

2. Gå in i din webbläsare och skriv in localhost:8080.

3. Nu så ska du se projektet. 
