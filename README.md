Etapa 1 - POO TV

Băban Mihai - Emilian, 324 CD

##Design Patterns

Am folosit Singleton pe DataBase si PagesStack unde parsez datele din Json pentru
a lua o singura instanta

##Pachete si clase

entitites contine:

-User - contine datele unui user si credentials

-Movie - contine datele unui film

-Page - in care retin numele paginii, utilizatorul curent,

lista de filme pe care o poate vedea si filmul curent

-Output - contine structura unui output. Daca trebuie sa afisez mesaj de eroare si

currentMovies si currentMovies gol instantiez constructorul fara parametrii, iar 

daca comanda s a realizat cu succez instantiez constructorul cu parametrii.

pentru a scrie in json folosesc metoda addInJsonArrayNode din Output

-PagesStack - contine stiva in care adaug paginile dupa fiecare actiune de change page

-Notification - contine numele filmului si mesajul

-Recommendation - contine structura unui output pentru o recomandare. Metoda

public void setRecommendedMovie(final Page page) adauga in vectorul de notificari

actions contine cate o clasa pentru fiecare tip de actiune care extind clasa Action

In clasa Main parcurg lista de actiuni si am folosit un switch case pe tipul actiunii.

Daca actiunea este de tipul "change page" instantiez clasa ActionChangePage, daca 

este de tipul "on page" ferific feature-ul actiunii si instantiez clasa corespunzatoare.


