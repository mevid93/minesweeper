**Aihe:** Miinaharavan klooni-versio. Miinaharavassa käytössä on pelilauta, jonka kaikki ruudut ovat alussa paljastamattomia. Laudalla on piilossa miinoja, joiden paikat tulee merkitä lipuilla. Pelaajan on tarkoitus hiirtä käyttäen tyhjentää pelikenttä ja merkitä siinä olevien miinojen sijainnit esille. Vasenta hiiren näppäintä käytetään paljastamattomiin ruutuihin. Ruudut joissa ei ole miinaa, näyttävät klikkauksen jälkeen montako miinaa niiden naapuriruuduissa on. Mikäli ruudussa sattuukin olemaan miina, peli päättyy.

Pelin nopeuttamiseksi tyjää ruutua (ei miinoja naapuriruuduissa) painettaessa peli paljastaa kaikki tyhjät ruudut jotka ovat klikattuun ruutuun yhteydessä. Tämän lisäksi paljastetaan myös ruudut, jotka ovat tyhjän alueen reunoilla ja joiden naapuriruuduissa on miina.

Hiiren oikeaa näppäinta käytetään paljstamattomiin ruutuihin, joissa pelaaja epäilee miinan sijaitsevan. Kun kaikki miinattomat ruudut on käyty läpi, pelaaja voittaa ja tuloksensa on käytetty aika. Pelissä on seuraavat vaikeustasot:

    helppo: pelikenttä on 9 x 9 ruutua ja miinoja on 10.
    keskivaikea: pelikenttä on 16 x 16 ruutua ja miinoja on 40.
    vaikea: pelikenttä on 30 x 16 ruutua ja miinoja on 99.

Näiden lisäksi on myös kustomoitu vaikeustaso, jossa pelikentän koon ja miinojen määrän pelaaja päättää.
** **

**Käyttäjät:** Kuka tahansa, joka haluaa pelata nostalgista peliä.
** **

**Ohjelman käyttäjän toiminnot**: 
- asetusten määrittäminen (pelikentän koon valitseminen)
- uuden pelin aloittaminen (pelikentän yläpuolella sijaitsevasta napista)
- ruudun klikkaaminen hiiren vasemmalla painikkeella (ruudun avaaminen)
- ruudun klikkaaminen hiiren oikealla painikkeella (ruudun liputtaminen tai lipun poisto ruudusta).
   
** **

**Luokkakaavio ja ohjelman rakenne**

![Luokkakaavio](/dokumentaatio/kuvat/viikon6Luokkakaavio.png)
<br/>
<br/>
Yllä on esiteltynä ohjelman luokkakaavio. Kuvassa on esitetty ohjelman kannalta oleellisimmat luokat. Kaikkia Käyttöliittymäkomponenttien luokkia ei ole yksinkertaistuksen vuoksi kaavioon sisällytetty.

Ohjelman toteutus jaettu pääasiassa kolmeen osaan, jotka ovat kuuntelijaluokat, käyttöliittymäluokat ja perusluokat.
Käyttöliittymäluokat sisältävät tiedon siitä millainen ohjelman näkymä käyttäjälle tulee olla. Käyttöliittymäluokkia ovat Kayttoliittyma.java, AsetuksetDialogi.java ja SaannotDialogi.java.

Kuuntelijaluokat sisältävät logiikan sille mitä tulee tehdä, kun käyttöliittymäluokan komponentteja painellaan. Kuuntelijaluokkia ovat AloitusnapinKuuntelija.java, RuutunapinKuuntelija.java ja ValikkonappienKuuntelija.java.

Perusluokat ovat ovat ovat ohjelman logiikan kannalta oleellisia. Ne pitävät muun muassa tietoa siitä mitä pelikentällä tapahtuu ja niiden avulla kuuntelijaluokat voivat määrittää mitä milloinkin tulee tehdä. Näitä "perusluokkia" ovat Pelikentta.java, Ruudukko.java, Ruutu.java ja Ruutunappi.java.
** **
<br/>
<br/>
<br/>
**Ohjelman käyttötapauksia sekvenssikaavioina**:
<br/>
<br/>
![Liputuksen vaihto sekvenssikaaviona](/dokumentaatio/kuvat/sekvenssikaavioLiputus.png)
<br/>
<br/>
<br/>
![Alusta aloittaminen sekvenssikaaviona](/dokumentaatio/kuvat/sekvenssikaavioAloitus.png)
<br/>
<br/>
Sekvenssikaaviossa, joka kuvaa pelin aloittamista alusta (alempi), on tärkeää huomata että uusien olioiden 
luominen korvaa aiemmat samannimiset oliot.
<br/>
<br/>
