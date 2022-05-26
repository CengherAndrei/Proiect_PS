#Proiect

Proiectul pe care am ales sa il implementez consta dintr-un sistem in care proprietarii de masini se pot inregista, sa isi adauge masinile 
personale respectiv actele fiecarei masini pentru a putea tine evidenta acestora. Am structurat programul in 4 pachete : Controller, Model, 
Repository, Service. Pachetul Model contine cele 3 clase corespunzatoare tabelelor din baza de date (Proprietar,Masina,Act) cu atributele, 
metodele si constructorii specifici. Pachetul Repository contine cate o interfata corespunzatoare fiecarei clase din Model, care  extinde 
CrudRepository necesara pentru implementarea operatiilor pe baza de date. Pachetul Service cate o interfata corespunzatoare fiecarei clase 
din Model respectiv implementarea acestor interfete. Acestea implementeaza logica aplicatiei continand metodele responsabile de operatiile 
asupra bazei de date. In pachetul controller am adaugat de asemenea 3 clase (cate un controller pentru fiecare model) care, dupa cum le 
spune numele, sunt responsabile de controlul aplicatiei si de apelarea metodelor din service.

#
Pentru tema 2 am implementat Factory Pattern creand mai multe tipuri de utilizatori : ProprietarBasic, ProprietarPremium si ProprietarAdmin. Singurele modificari asupra codului au fost facute in pachetul Model unde am adaugat cate o clasa pentru fiecare tip de utilizator dar si un Enum. Totodata am creat teste pentru toate entitatile si le-am structurat pe pachete astfel: pachetul de test in care am inserat pachete corespunzatoare fiecarui pachet din proiect (cele 4) iar in fiecare pachet cate o clasa de test corespunzatoare fiecarei clase implementate anterior. Am adaugat totodata si diagrama de clasa si diagrama bazei de date.

![BazaDeDate](https://user-images.githubusercontent.com/72455865/170509605-2d1748dc-bc80-4268-9f31-ccb4fb7d34d1.png)
![Package accessingdatamysql](https://user-images.githubusercontent.com/72455865/170509801-98ab8a3a-10f3-4faa-a54a-cb385a071009.png)

Pentru această parte a proiectului, am creat o aplicație Android pentru dezvoltarea partii de frontend. Limbajul de programare în care a fost scrisă aplicația este kotlin, iar în proiect avem 11 fișiere, care reprezintă activități pentru aplicație,pentru fragmente, clasele model, clasa de date și interfața de comunicare cu backend-ul care a fost dezvoltat în spring boot.
Mai intai avem 3 clase de date pentru maparea datelor care provin din cerere :Data_pr, Data_ma, Data_act.
Pentru a face o cerere API avem o interfață (ApiInterface) unde am mapat toate solicitările necesare pentru un comportament normal al aplicației. În această interfață există 9 cereri prin care se preia date și se pun datele în baza de date.(get,post,delete)
La final exista 3 fragmente pe care a fost dezvoltata aplicația (HomeFragment, DashboardFragment, NotificationsFragment ). Cele 3 contin metodele onCreateView care creeaza efectiv fragmentul corespunzator tabelului, onDestroyView care sterge fragmentul si getMyData responsabila de realizarea interogarii pentru a extrage toate datele din bazele de date. Pe langa aceasta, clasele mai contin actiunile specifice celor 3 butoane (adaugare, stergere,afisare) impreuna cu procesarea datelor din EditText.
Pentru fiecare fragment si activitate care a fost creată în folderul layout-uri va fi creat un fișier xml pentru dezvoltarea designului paginii. Android Studio oferă două moduri de a efectua această sarcină, mai întâi se scrie codul în fișierul xml, a doua modalitate este cea de glisare și plasare de unde se creeaza propriul design. De asemenea, avem un fișier xml în care sunt stocate referințe la toate activitățile și permisiunile utilizatorului. Android Studio oferă posibilitatea de a dezvolta imaginea de fundal a aplicației dvs. pentru fiecare pagină, desenați obiecte care vor fi afișate. Se pot instanția culori pentru aplicația dvs. și puteți crea o temă, cum ar fi tema modului luminos sau tema modului întunecată. În structura proiectului există un folder specific pentru scripturi și biblioteci de inițiere pentru proiect. Fișierele principale sunt modulul de aplicație build.gradle, modulul de proiect build.gradle și gradle.properties.
Această parte a proiectului a fost adaugata într-un alt commit (urmatorul link pentru aceasta parte a proiectului: https://github.com/CengherAndrei/Frontend_evidenta-masinii) deoarece această parte a fost dezvoltată în Android Studio.
