#Proiect

Proiectul pe care am ales sa il implementez consta dintr-un sistem in care proprietarii de masini se pot inregista, sa isi adauge masinile 
personale respectiv actele fiecarei masini pentru a putea tine evidenta acestora. Am structurat programul in 4 pachete : Controller, Model, 
Repository, Service. Pachetul Model contine cele 3 clase corespunzatoare tabelelor din baza de date (Proprietar,Masina,Act) cu atributele, 
metodele si constructorii specifici. Pachetul Repository contine cate o interfata corespunzatoare fiecarei clase din Model, care  extinde 
CrudRepository necesara pentru implementarea operatiilor pe baza de date. Pachetul Service cate o interfata corespunzatoare fiecarei clase 
din Model respectiv implementarea acestor interfete. Acestea implementeaza logica aplicatiei continand metodele responsabile de operatiile 
asupra bazei de date. In pachetul controller am adaugat de asemenea 3 clase (cate un controller pentru fiecare model) care, dupa cum le 
spune numele, sunt responsabile de controlul aplicatiei si de apelarea metodelor din service.