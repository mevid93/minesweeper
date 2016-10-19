# Testausdokumentaatio

#### JUnit yksikkötestit
JUnit yksikkötestejä on laadittu miinaharava.domain-pakkauksessa oleville luokille. Näiden "perusluokkien" testaaminen oli mielekästä suorittaa kyseisellä tavalla. Pääasiassa testit tarkastavat, että luokkien säilyttämät arvot käyttäytyvät halutulla tavalla, eri metodeja kutsuttaessa.
<br/>
#### Muu testaus
Kahden muun pakkauksen (miinaharava.kayttoliittyma ja miinaharava.kuuntelijat) testaus suoritettiin manuaalisesti. Nämä pakkaukset liittyivät sen verran vahavasti käyttöliittymään, joten niiden testaaminen ei ollut järkevää yksikkötestien avulla. Testaus suoritettiin käyttöliittymän komponentteja klikkailemalla. Tämän seurauksena kuuntelijaluokkien tuli rekisteröidä erilaisia tapahtumia, jotka muuttivat käyttöliittymää. Testausta suoritettiin jokaiselle käyttöliittymän komponentille vuorotellen eri ohjelman suoritusvaiheissa. Näin varmistettiin, että ohjelma toimisi halutulla tavalla. Luokkien testaus hoitui pitkälti ohjelmakoodin kirjoittamisen yhteydessä. Kun uutta koodia saatiin aikaiseksi, testattiin sen toiminta heti suorittamalla ohjelma ja tarkastamalla, että muutokset käyttöliittymässä olivat suunnitellut.
<br/>
#### Tunnetut viat ja puutteet (bugit)
Ohjelma on laadittu Full HD resoluutioista näyttöä käyttäen. Ohjelma ei skaalaudu automaattisesti käytetyn resoluution mukaan, vaan ohjelman koko määräytyy valmiiksi annetun leveyden ja korkeuden (pixeleinä) perusteella. Tästä johtuen ohjelman käyttöliittymä ei todennäköisesti mahdu vaikeammilla vaikeustasoilla kokonaan ruudulle, mikäli käytetty resoluutio on alhainen. Tämän voi todeta helposti vaihtamalla näytön resoluution pienemmälle, käynnistämällä ohjelman ja asettamalla vaikeustasoksi "vaikean".



