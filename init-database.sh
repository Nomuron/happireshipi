#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER docker;

    CREATE TABLE meal(
        id int not null,
        "name" varchar(100) not null,
        per_portion_calories int not null,
        category varchar(10) not null,
        image_directory varchar(400) not null,
        recipe text not null,
        proteins float not null,
        carbohydrates float not null,
        fats float not null,
        PRIMARY KEY(id)
    );

    INSERT INTO meal(id, name, per_portion_calories, category, image_directory, recipe, proteins, carbohydrates, fats)
    VALUES (1, 'Fondant czekoladowy', 600, 'deser', '/00001_fondant_czekoladowy.jpeg', 'Krok1:
           Z podanej przeze mnie liczby składników wychodzą dwa desery pieczone Lava Cake (średnica u podstawy 10 cm, zaś wysokość około 4 cm). Można też sięgnąć np. po wyższe kokilki. Użyłam metalowych foremek o pojemności 230 ml, więc fondant czekoladowy nie wypełnił ich całych na wysokość. Nie ma to jednak znaczenia, ponieważ lava cake i tak wyjmujemy z foremki do podania. Foremki należy bardzo dokładnie wysmarować od środka masłem, a następnie oprószyć mąką.
           Krok2:
           50 gramów (klasyczna tabliczka) dobrej jakości czekolady gorzkiej (u mnie 70 %) roztop razem z masłem w kąpieli wodnej. Czekoladę warto wcześniej posiekać drobno lub połamać na małe kawałki. Masło również można pokroić na mniejsze kawałki.
           Krok3:
           Tak więc miskę szklaną umieść na garnuszku do 1/3 wypełnionym wrzątkiem. Dno miseczki nie powinno dotykać do wody, za to ma być na tyle szerokie, by można je było umieścić - na garnku. Ustaw małą moc palnika i cierpliwie czekaj, aż czekolada zacznie się powoli roztapiać. Zazwyczaj cały czas mieszam sobie w misce np. szpatułką. Gdy czekolada będzie już praktycznie roztopiona, do miski dodaję też 25 gramów masła i mieszam całość tak długo, aż masło połączy się z czekoladą.
           Krok4:
           Gotową, gładką i błyszczącą czekoladową mieszankę zdejmij z garnka i odłóż na bok, do lekkiego przestudzenia. Możesz już zacząć nagrzewać piekarnik razem z kratką lub blaszką, na której położysz gotowe do pieczenia foremki z Lava Cake. Ustaw 200 stopni z opcją pieczenia góra/dół.
           Krok5:
           Do osobnej miski wbij jajko. Dodaj pół szczypty soli i wsyp 15 gramów cukru drobnego, czyli 1,5 płaskiej łyżki cukru. Całość miksuj na wysokich obrotach tak długo, aż cukier rozpuści się w jajka i powstanie Ci puch jajeczny. Jeśli dasz cukier puder zamiast cukru drobnego, to zapewne puch jajeczny będzie gotowy o kilka minut szybciej.
           Krok6:
           Cienką strużką wlewaj przestudzoną (może być jeszcze lekko ciepła) czekoladę z masłem. Cały czas mieszaj też powoli puch jajeczny przy pomocy szpatułki. Gdy dodasz już całą płynną czekoladę, to do miski wsyp też łyżkę mąki (najlepiej rzez sitko) i dalej powoli i delikatnie mieszaj wszystko szpatułką, aż powstanie Ci jednolita masa. Lava Cake można też urozmaicić dodając do masy np. odrobiny ekstraktu waniliowego, bardzo mocno parzoną kawę (przestudzona esencja) w niewielkiej ilości albo też szczyptę cynamonu.
           Krok7:
           Masę przelej do przygotowanych wcześniej dwóch foremek.
           Krok8:
           Foremki umieść w piekarniku nagrzanym do 200 stopni z opcją pieczenia góra/dół. Pamiętaj o tym, że nagrzana ma być też kratka lub blaszka, na której położysz gotowe do pieczenia foremki z Lava Cake. Fondant czekoladowy piecz tak około 8 minut lub też do 10 minut jeśli wolisz, by środek nie był bardzo płynny. Lava cake wyjmujemy z pieca od razu po upieczeniu.
           Krok9:
           Po kilku minutach od upieczenia przyłóż talerzyk do foremki i odwróć go, by lava cake ładnie wyskoczyło na talerz. Fondant czekoladowy można przed podaniem oprószyć cukrem pudrem lub kakao i udekorować np. malinami, borówkami, truskawkami, czy też innymi ulubionymi owocami (również mrożone). Lava cake świetnie smakuje w towarzystwie lodów waniliowych lub czekoladowych.', 7.7, 28.3, 28),
           (2, 'Wegetariańska Carbonara', 700, 'obiad', '/00002_wegetarianska_carbonara.jpeg', 'Krok1:
           Rozgrzej piekarnik do 220 stopni Celsjusza. Ciecierzycę odsącz z zalewy; wysusz za pomocą ściereczki lub ręcznika papierowego. Przełóż na blachę wyłożoną papierem do pieczenia. Wymieszaj dokładnie z oliwą, wędzoną papryką i solą. Piecz przez około 20 minut, mieszając raz czy dwa, aż ciecierzyca będzie chrupiąca.
           Krok2:
           Ugotuj makaron wg instrukcji na opakowaniu. Odcedź go, zachowując ¼ szklanki wody.
           Krok3:
           W dużej misce wymieszaj dokładnie żółtka z parmezanem i czosnkiem. Dopraw dużą ilością świeżo mielonego pieprzu i szczyptą soli.
           Krok4:
           Ugotowany makaron wmieszaj do masy jajecznej wraz z ¼ szklanki zachowanej wody, łyżką zimnego masła, aż pokryje się kremowo-jajecznym sosem. Najlepiej robić to za pomocą szczypiec. Jeśli sos będzie zbyt rzadki, przełóż go wraz z makaronem go garnka, w którym się gotował. Podgrzewaj na małym ogniu, często mieszając. Dodaj odrobinę zachowanej wody, jeśli sos będzie zbyt zgęstnieje. Wmieszaj ¾ chrupiącej ciecierzycy.
           Krok5:
           Carbonarę przełóż na talerze, posyp pozostałą chrupiącą ciecierzycą. Dopraw świeżo mielonym pieprzem, szczyptą wędzonej papryki i odrobiną świeżego tymianku.', 4, 8.8, 5.2),
           (3, 'Makaron z kurczakiem i brokułem w sosie serowym', 700, 'obiad', '/00003_makaron_z_kurczakiem_i_brokułem_w_sosie_serowym.jpeg', 'Krok1:
           Ugotuj makaron taki jaki lubisz. Najlepiej penne lub kokardki.
           Krok2:
           Pokrój kurczaka w kostkę, dopraw solą, pieprzem, przyprawą do kurczaka. Usmaż z odrobiną oleju rzepakowego.
           Krok3:
           Umyj i pokrój według własnych preferencji brokuł. Ugotuj go – na miękko lub twardo – jak lubisz.
           Krok4:
           W rondelku umieść serki topione oraz wlej ok. 15 ml mleka. Pamiętaj, że sos szybko może się przypalić, więc bardzo częste mieszanie jest wskazane. Gdy serek się rozpuści dopraw sos pieprzem, szczyptą (lub jak wolisz) oregano. Zdecyduj, czy gęstość sosu Tobie odpowiada. Jeśli jest za gęsty, dolej więcej mleka.
           Krok5:
           Gotowy makaron umieść na talerzach, połóż na wierzch kawałki ugotowanego brokułu i usmażonego kurczaka. Polej sosem.', 5, 10, 4.5),
           (4, 'Penne alla Vodka', 609, 'obiad', '/00004_penne_alla_vodka.png', 'Krok1:
           Na dużej patelni smaż na sucho siekane prosciutto (możesz wymienić je boczkiem).
           Krok2:
           Gdy prosciutto będzie podsmażone dodaj oliwę i siekana szalotka z czosnkiem. Smaż.
           Krok3:
           Dodaj rozmieszczone pomidory pelati, wódkę i do tego bazylię. Przypraw solą i pieprzem. Zdejmij bazylię.
           Krok4:
           Dodał śmietankę i zimne masło. Sos gotuj na małym ogniu w tym czasie przygotuj makaron.
           Krok5:
           Gotuj makaron al dente.
           Krok6:
           Gdy sos lekko zgęstnieje (część wody odparuje) dodaj makaron do sosu, posyp odrobiną parmezanu, siekaną natką pietruszki i podaj na talerz!', 8.4, 20.5, 9.4),
           (5, 'Bajgiel z jajkiem sadzonym', 190, 'śniadanie', '/00005_bajgiel_z_jajkiem_sadzonym.jpeg', 'Krok1:
           Przygotuj jajka sadzone wedle uznania.
           Krok2:
           Podsmaż szynkę szwarcwaldzką na patelni.
           Krok3:
           Pokrój pomidora, ogórek, umyj parę listków sałaty.
           Krok4:
           Przekrój bajgla na pół. Obie połówki połóż na tosterze wnętrzem do dołu i opiekaj przez 3 min.
           Krok5:
           Na opieczoną dolną część bajgla połóż liść/liście sałaty, posmaruj musztardą, przykryj podsmażoną szynkę szwarcwaldzką. Na wierzch dodaj jajko sadzone, pokrojone plastry pomidora oraz ogórka. Przykryj górną częścią bajgla. Smacznego!', 12.6, 25.6, 7.6),
           (6, 'Tarta cytrynowa na palonym maśle', 332, 'deser', '/00006_tarta_cytrynowa_na_palonym_masle.jpeg', 'Krok1:
           Najlepiej przygotować danie na 10 porcji. Opis poniżej względem 10 porcji.
           Jedną cytrynę pokrój w najcieńsze plasterki, jak tylko potrafisz; pozbądź się pestek. Z pozostałych 4 cytryn wyciśnij sok. Połącz sok cytrynowy z 1 szklanką cukru, tworząc swego rodzaju -lemoniadę. Spróbuj, jeśli jest dla ciebie za kwaśna, dodaj trochę więcej cukru. Zanurz w niej cytryny. Odstaw na minimum godzinę, a najlepiej całą noc do lodówki. Kilkukrotnie przemieszaj, aby rozprowadzić cukier. Czym cytryna bardziej zmięknie, tym tarta wyjdzie smaczniejsza. Macerowanie przez godzinę jest czasem minimalnym, ale warto sobie zorganizować wcześniej pieczenie i nastawić cytrynę wieczorem, aby zdążyła idealnie zmięknąć. Zbyt krótki czas macerowania będzie skutkować trudnością krojenia tarty, a następnie jej jedzenia.
           Krok2:
           Formę do tarty z wyjmowanym dnem o średnicy 23 cm lub tortownicę wysmaruj masłem i obsyp mąką.
           Krok3:
           200 g mąki połącz z cukrem pudrem i 1,5 płaskiej łyżeczki soli. W garnuszku rozpuść masło, gotuj je na średnim ogniu, często mieszając, 5 – 8 minut, do momentu, aż zacznie orzechowo pachnieć i nabierać złotobrązowego koloru z ciemnymi plamkami. Ostudź palone masło.
           Krok4:
           Palone masło wlej do wcześniej przygotowanej w kroku 3 mąki; połącz wszystko drewnianą łyżką. Powstanie lekko wilgotna masa; wylep nią formę. Ciasto obsyp odrobiną mąki. Możesz pomóc sobie szklanką, dociskając nią ciasto w formę. Schłodź spód w lodówce 30 – 40 minut lub zamrażarce 10 – 15 minut, do całkowitego stężenia.
           Krok5:
           Rozgrzej piekarnik do 190 stopni Celsjusza (góra-dół).
           Krok6:
           W międzyczasie przygotuj nadzienie. Wyjmij pasterki cytryny z lemoniady. Bardzo dokładnie połącz ją z 2 jajkami, 3 żółtkami, 30 g mąki i ¼ łyżeczki soli. Najlepiej zrobić to blenderem ręcznym, aby łatwo pozbyć się wszystkich grudek mąki. Uderz kilka razy miską o stół, aby pozbyć się pęcherzyków powietrza, które wytworzyły się podczas miksowania. Przełóż płynne nadzienie na mocno schłodzony spód. Ułóż plasterki cytryn po całej powierzchni.
           Krok7:
           Piecz przez 30 – 35 minut, aż nadzienie się zetnie i przestanie być -galaretkowate. Jeśli tarta zacznie nabierać rumieńców podczas pieczenia, przykryj ją folią aluminiową. Wystudź przed podaniem. Tarta najlepiej smakuje z kleksem bitej śmietany, labneh lub o mój boże, gałką lodów waniliowych.', 6.3, 45, 17.5),
           (7, 'Ragu alla bolognese', 750, 'obiad', '/00007_ragu_alla_bolognese.jpeg', 'Krok1:
           Najlepiej przygotować danie na 4 porcje.
           Przygotuj soffrito: obierz cebulę i przekrój na pół. Następnie połóż połówki cebuli płaską stroną na desce do krojenia i pokrój w plasterki, a następnie w drobną kostkę. Usuń końcówki marchwi za pomocą małego noża i obieraczką do ziemniaków obierz marchewkę i umyj pod bieżącą wodą. Pokrój marchewkę na bardzo cienkie podłużne plastry, następnie plastry przekrój na pół i w kostkę. Umyj seler, usuń liście i górną część selera. Usuń zewnętrzną powłokę za pomocą obieraczki do ziemniaków. Podziel seler na pół i potnij na cienkie paski, a następnie pokrój w małą kostkę. Podgrzej oliwę z oliwek na patelni, a następnie dodaj pokrojoną cebulę, marchew i seler naciowy. Smaż warzywa na małym ogniu przez co najmniej 15 minut od czasu do czasu mieszając. Nie przyprawiaj, gdyż jest to baza do twoich dań i będzie przyprawiona w czasie przygotowywania potrawy.
           Krok2:
           Na patelni rozgrzej oliwę (kilka łyżek) i podsmaż na niej boczek, czekając aż zacznie wytapiać się z niego tłuszcz.
           Krok3:
           Dodaj do boczku przygotowane uprzednio soffritto i grubo zmieloną wołowinę. Całość smaż przez 10 minut mieszając od czasu do czasu.
           Krok4:
           Do patelni dolej białego wina, a na czas aż alkohol wyparuje zwiększ ogień. Po wyparowaniu alkoholu dodaj do sosu pomidorową passatę. Całość zalej gorącym bulionem. Dodaj szczyptę soli, zamieszaj i gotuj na średnim ogniu przez minimum 2 godziny. Co jakiś czas mięso zamieszaj i w razie potrzeby (jeśli ragu będzie zbyt suche) dolej odrobinę bulionu. Na koniec całość dopraw solą i pieprzem, wyłącz grzanie pod garnkiem i dodaj mleko. Całość dokładnie wymieszaj i sos gotowy.
           Krok5:
           Ugotuj makaron, najlepiej taglatelle według uznania – proponujemy al dente.
           Krok6:
           Do misek rozłóż makaron, dodaj ragu i posyp odrobiną parmezanu. Smacznego!', 11.5, 11.6, 7),
           (8, 'Indyjska bhorta z paluszkami rybnymi', 635, 'obiad', '/00008_indyjska_bhorta_z_paluszkami_rybnymi.jpeg', 'Krok1:
           Zacznij od piklowanej cebuli. Pół cebuli czerwonej posiekanej w cienkie pióra przełóż do słoika lub miski. Zalej octem, tak aby była cała zanurzona. Odstaw do lodówki na min. 1 godzinę.
           Krok2:
           Rozgrzej piekarnik do 220 stopni Celsjusza. Piecz paluszki rybne 30 – 40 minut, aż będą bardzo mocno wypieczone. Za pomocą widelca rozgnieć na mniejsze kawałki.
           Krok3:
           Rozgrzej oliwę dużej patelni. 2 posiekane białe cebule w cienkie pióra - smaż na stosunkowo małym ogniu, często mieszając, aż się skarmelizuje i nabierze karmelowego koloru, około 20 minut. Jeśli cebula zacznie się przypalać, dodaj szczodrą szczyptę soli, dzięki niej cebula puści trochę wody. Na koniec dodaj cukier i smaż jeszcze 1 – 2 minuty.
           Krok4:
           Dodaj chili, imbir utarty na tarce i czosnek – zmiażdżony lub pokrojony. Smaż, często mieszając, aż zaczną intensywnie pachnieć, 2 – 3 minuty. Wmieszaj musztardę, przemieszaj wszystko. Dodaj szpinak i gotuj, mieszając, aż całkowicie straci na objętości. Dopraw solą i pieprzem; wyciśnij sok z limonki. Zdejmij z ognia i dodaj paluszki rybne. Przełóż na talerze. Udekoruj piklowaną cebulą i kolendrą. Czy to nie jest wspaniałe?', 10.5, 13.1, 23.6),
           (9, 'Pieczony kalafior', 250, 'obiad', '/00009_pieczony_kalafior', 'Krok1:
           Ze swojego kalafiora zdejmij okalające go ścisło liście i odetnij wystający głąb. Ostrożnie odetnij wszystkie różyczki kalafiora. Krok2:
           Różyczki umieść na sitku i przepłucz pod zimną, bieżącą wodą. Po obraniu i odkrojeniu różyczek wyszło mi 790 gramów gotowych do pieczenia różyczek kalafiora. Obierz też jedną lub dwie marchewki i pokrój je w plasterki. Marchewkę można pominąć.
           Krok3:
           W małej miseczce umieść wszystkie przyprawy: łyżeczka słodkiej papryki; pół łyżeczki soli lub trochę więcej; po 1/3 płaskiej łyżeczki pieprzu, ostrej papryki i mielonego kminu; szczypta kurkumy. Wlej też cztery łyżki delikatnej oliwy lub innego oleju roślinnego. Aby kalafior był lekko słodki i bardziej się przypiekł, można dodać też odrobinę cukru pudru, miodu lub syropu. Do przypraw warto też wycisnąć jeden ząbek czosnku. Całość wymieszaj i wylej na różyczki kalafiora i plasterki marchewki.
           Krok4:
           Blaszkę umieść w piekarniku nagrzanym do 190-200 stopni. Wybierz środkową półkę i piecz warzywa do 35 minut z opcją pieczenia góra/dół. Jeśli masz małą komorę lub Twoje warzywa podpiekają się już po 10 minutach, to zmniejsz moc palnika do 180 stopni. Moje piekły się przez 30 minut. Nie przewracałam ich na drugą stronę. Jeśli jednak chcesz, by warzywa były od góry zarumienione, to pod koniec pieczenia przełącz piekarnik na opcję grillowania od góry. Porada: Na kilka minut przed końcem pieczenia można posypać całość tartym serem żółtym lub parmezanem oraz dodać pokruszone orzechy włoskie, nerkowce lub pekan. Kalafior pieczony podawaj gorący maczając go w ulubionym sosie np. czosnkowym lub jogurtowym. Warto udekorować go natką pietruszki a dla smaku skropić świeżo wyciskanym sokiem z cytryny.', 4, 3.1, 10.2),
           (10, 'Tosty z serem i szynką', 400, 'kolacja', '/00010_tosty_z_serem_i_szynką', 'Krok1:
           Kromki chleba tostowego posmaruj masłem.
           Krok2:
           Pokrój na plasterki szynkę oraz ser.
           Krok3:
           Połóż na jedną kromkę plasterek sera oraz szynki. Posyp oregano.
           Krok4:
           Przykryj drugą kromką. Zapiekaj przez ok. 4 min w opiekaczu.
           Krok4:
           Połóż opieczone tosty na talerze i smacznego! 1 porcja przewiduje jednego tosta.', 13, 30, 8);

    CREATE TABLE ingredient(
        id int not null,
        measure varchar(40) not null,
        "name" varchar(70) not null,
        PRIMARY KEY(id)
    );

    INSERT INTO ingredient(id, measure, name)
    VALUES (1, 'g', 'gorzka czekolada'),
           (2, 'sztuka', 'jajko'),
           (3, 'g', 'masło'),
           (4, 'g', 'cukier'),
           (5, 'g', 'mąka pszenna'),
           (6, 'szczypta', 'sól'),
           (7, 'g', 'ciecierzyca'),
           (8, 'łyżka', 'oliwa extra virgin'),
           (9, 'łyżeczka', 'wędzona papryka przyprawa'),
           (10, 'g', 'makaron'),
           (11, 'g', 'parmezan'),
           (12, 'ząbek', 'czosnek'),
           (13, 'szczypta', 'pieprz mielony'),
           (14, 'szczypta', 'tymianek'),
           (15, 'sztuka', 'pierś z kurczaka'),
           (16, 'sztuka', 'serek topiony śmietankowy'),
           (17, 'ml', 'mleko'),
           (18, 'szczypta', 'oregano'),
           (19, 'szczypta', 'przyprawa do kurczaka'),
           (20, 'łyżka', 'olej rzepakowy'),
           (21, 'g', 'pomidory krojone w puszce'),
           (22, 'sztuka', 'szalotka'),
           (23, 'g', 'prosciutto'),
           (24, 'ml', 'śmietanka 30%'),
           (25, 'ml', 'wódka 40%'),
           (26, 'sztuka', 'natka pietruszki'),
           (27, 'g', 'świeża bazylia'),
           (28, 'sztuka', 'bajgiel'),
           (29, 'opakowanie', 'szynka szwarcwaldzka'),
           (30, 'sztuka', 'sałata'),
           (31, 'sztuka', 'pomidor '),
           (32, 'szuka', 'ogórek'),
           (33, 'łyżeczka', 'musztarda'),
           (34, 'g', 'cukier puder'),
           (35, 'sztuka', 'cytryna'),
           (36, 'g', 'mielona wołowina'),
           (37, 'g', 'boczek wieprzowy'),
           (38, 'g', 'passata pomidorowa'),
           (39, 'sztuka', 'marchewka'),
           (40, 'sztuka', 'cebula'),
           (41, 'sztuka', 'seler naciowy'),
           (42, 'ml', 'białe wino'),
           (43, 'łyżka', 'oliwa z oliwek'),
           (44, 'ml', 'bulion mięsny'),
           (45, 'ml', 'mleko'),
           (46, 'sztuka', 'paluszki rybne'),
           (47, 'sztuka', 'cebula biała'),
           (48, 'sztuka', 'cebula czerwona'),
           (49, 'sztuka', 'papryczka chilli'),
           (50, 'szczypta', 'imbir przyprawa'),
           (51, 'g', 'szpinak baby'),
           (52, 'sztuka', 'limonka'),
           (53, 'sztuka', 'świeża kolendra'),
           (54, 'sztuka', 'ocet z czerwonego wina'),
           (55, 'sztuka', 'kalafior'),
           (56, 'szczypta', 'papryka słodka  przyprawa'),
           (57, 'szczypta', 'papryka ostra przyprawa'),
           (58, 'szczypta', 'mielony kmin'),
           (59, 'szczypta', 'kurkuma przyprawa'),
           (60, 'bochenek', 'chleb tostowy'),
           (61, 'g', 'ser'),
           (62, 'g', 'szynka');

    CREATE TABLE meal_ingredient(
        id int not null,
        meal_id int not null,
        ingredient_id int not null,
        amount float not null,
        PRIMARY KEY(id)
    );

    INSERT INTO meal_ingredient(id, meal_id, ingredient_id, amount)
    VALUES (1, 1, 1, 50),
           (2, 1, 2, 1),
           (3, 1, 3, 25),
           (4, 1, 4, 15),
           (5, 1, 5, 0.5),
           (6, 1, 6, 0.5),
           (7, 2, 7, 200),
           (8, 2, 8, 1.5),
           (9, 2, 9, 3),
           (10, 2, 6, 4),
           (11, 2, 10, 100),
           (12, 2, 2, 3),
           (13, 2, 11, 15),
           (14, 2, 12, 0.5),
           (15, 2, 3, 0.5),
           (16, 2, 13, 1),
           (17, 2, 14, 1),
           (18, 3, 10, 100),
           (19, 3, 15, 0.5),
           (20, 3, 16, 1),
           (21, 3, 17, 25),
           (22, 3, 6, 1),
           (23, 3, 13, 1),
           (24, 3, 18, 1),
           (25, 3, 19, 5),
           (26, 3, 20, 10),
           (27, 4, 10, 125),
           (28, 4, 21, 200),
           (29, 4, 22, 0.5),
           (30, 4, 12, 1),
           (31, 4, 23, 50),
           (32, 4, 24, 75),
           (33, 4, 3, 25),
           (34, 4, 25, 40),
           (35, 4, 6, 3),
           (36, 4, 13, 4),
           (37, 4, 43, 4),
           (38, 4, 26, 1),
           (39, 4, 11, 25),
           (40, 4, 27, 10),
           (41, 5, 28, 1),
           (42, 5, 2, 1),
           (43, 5, 29, 0.5),
           (44, 5, 30, 0.5),
           (45, 5, 31, 0.5),
           (46, 5, 32, 0.5),
           (47, 5, 33, 2),
           (48, 6, 5, 23),
           (49, 6, 34, 5),
           (50, 6, 6, 3),
           (51, 6, 3, 15),
           (52, 6, 35, 0.5),
           (53, 6, 4, 20),
           (54, 6, 2, 0.5),
           (55, 7, 36, 75),
           (56, 7, 37, 37.5),
           (57, 7, 38, 75),
           (58, 7, 39, 0.25),
           (59, 7, 40, 0.25),
           (60, 7, 41, 0.25),
           (61, 7, 42, 30),
           (62, 7, 43, 6),
           (63, 7, 44, 62.5),
           (64, 7, 45, 30),
           (65, 7, 6, 4),
           (66, 7, 13, 4),
           (67, 7, 10, 125),
           (68, 7, 11, 12.5),
           (69, 8, 46, 6),
           (70, 8, 43, 2.5),
           (71, 8, 47, 1),
           (72, 8, 48, 0.25),
           (73, 8, 4, 0.5),
           (74, 8, 49, 0.5),
           (75, 8, 50, 0.5),
           (76, 8, 12, 1),
           (77, 8, 33, 1),
           (78, 8, 51, 100),
           (79, 8, 52, 0.5),
           (80, 8, 53, 0.5),
           (81, 8, 6, 2),
           (82, 8, 13, 2),
           (83, 8, 54, 0.5),
           (84, 9, 55, 0.5),
           (85, 9, 39, 1),
           (86, 9, 12, 2),
           (87, 9, 43, 2),
           (88, 9, 56, 0.5),
           (89, 9, 6, 3),
           (90, 9, 13, 4),
           (91, 9, 57, 4),
           (92, 9, 58, 4),
           (93, 9, 59, 1),
           (94, 10, 60, 0.15),
           (95, 10, 61, 20),
           (96, 10, 62, 20),
           (97, 10, 3, 7),
           (98, 10, 18, 2);

    CREATE TABLE "user"(
        login varchar(150) not null,
        password varchar(150) not null,
        PRIMARY KEY(login)
    );

    INSERT INTO "user"(login, password)
    VALUES ('stefan', 'Zuparomana#');
EOSQL