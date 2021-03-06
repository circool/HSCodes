С 1 января 2012 в соответствии с Решением КТС ЕврАзЭС от 18.11.2011 № 850 «О новой редакции Единой товарной номенклатуры внешнеэкономической деятельности таможенного союза и единого тарифа таможенного союза» используется классификатор Товарной номенклатуры внешнеэкономической деятельности Таможенного союза (классификатор ТН ВЭД).
Товарная номенклатура внешнеэкономической деятельности основывается на Гармонизированной системе описания и кодирования товаров Всемирной таможенной организации и единой Товарной номенклатуре внешнеэкономической деятельности Содружества Независимых Государств.
Товарная номенклатура внешнеэкономической деятельности утверждается Комиссией таможенного союза.
Решения о внесении изменений в Товарную номенклатуру внешнеэкономической деятельности принимаются Комиссией таможенного союза на основании предложений таможенных органов в установленном порядке.
Техническое ведение Товарной номенклатуры внешнеэкономической деятельности осуществляет государственный орган исполнительной власти Российской Федерации, уполномоченный в сфере таможенного дела (ФТС России).
Федеральная налоговая служба использует в системе АИС «Налог» классификатор ТН ВЭД, получаемый от ФТС России в соответствии с протоколом информационного взаимодействия между ведомствами, и доводит его до налоговых служб Республики Беларусь и Республики Казахстан. Также ТН ВЭД используется налогоплательщиками государств - членов Таможенного союза при заполнении заявления о ввозе товаров и уплате косвенных налогов.
Классификатор ТН ВЭД размещается в четырёх текстовых файлах (кодировка DOS), по уровням классификации товаров:
•	 “Разделы ТН ВЭД”  (TNVED1.TXT);
•	 “Группы ТН ВЭД”   (TNVED2.TXT);
•	 “Товарные позиции ТН ВЭД”   (TNVED3.TXT);
•	 “Товарные подпозиции ТН ВЭД”   (TNVED4.TXT).

В первой строке каждого файла указывается номер и дата версии каждого файла справочника.

«Разделы ТН ВЭД» (TNVED1)
№ п/п	Наименование поля	Формат	Содержание реквизита	        Ключевые поля
1	    RAZDEL	            C(2)	Разделы ТН ВЭД 	                #
2	    NAIM	            C(4000)	Наименование
3	    PRIM	            C(4000)	Примечание
4	    DATA	            DATE	Дата начала действия раздела	#
5	    DATA1	            DATE	Дата окончания действия раздела

«Группы ТН ВЭД» (TNVED2)
№ п/п	Наименование поля	Формат	Содержание реквизита	        Ключевые поля
1	    RAZDEL	            C(2)	Разделы ТН ВЭД
2	    GRUPPA	            C(2)	Группы ТН ВЭД	                #
3	    NAIM	            C(4000)	Наименование
4	    PRIM	            C(4000)	Примечание
5	    DATA	            DATE	Дата начала действия группы	    #
6	    DATA1	            DATE	Дата окончания действия группы

«Товарные позиции ТН ВЭД»  (TNVED3)
№ п/п	Наименование поля	Формат	Содержание реквизита	Ключевые поля
1	    GRUPPA	            C(2)	Группы ТН ВЭД	                #
2	    TOV_POZ	            C(2)	Товарные позиции	            #
3	    NAIM	            C(4000)	Наименование
5	    DATA	            DATE	Дата начала действия позиции	#
6	    DATA1	            DATE	Дата окончания действия позиции

«Товарные подпозиции ТН ВЭД»  (TNVED4)
№ п/п	Наименование поля	Формат	Содержание реквизита	Ключевые поля
1	    GRUPPA	            C(2)	Группы ТН ВЭД	                #
2	    TOV_POZ	            C(2)	Товарные позиции	            #
3	    SUB_POZ	            C(6)	Товарные подпозиции	            #
4	    KR_NAIM	            C(200)	Краткое наименование товара
5	    DATA	            DATE	Дата начала действия подпозиции	#
6	    DATA1	            DATE	Дата окончания действия подпозиции

Обращение к справочнику из таможенных документов  производится по полному коду товара. Полный код товара образуется объединением граф справочника
GRUPPA + TOV_POZ + SUB_POZ
В публикуемом варианте справочника исключена информация, действовавшая до 01.01.2003 г.

Формат конечного кода:
0000 00 000 0

* Прим Vladimir Tsurkanenko: Формат файлов изменен на UTF-8
** В справочнике отсутствуют товарные позиции и подпозиции, которые в оригинальных документах обозначены кодами, длинной менее 10 цифр, например:

    0101 29 - - прочие:
    0102 Крупный рогатый скот живой:
        - домашний крупный рогатый скот:
    0102 21 - - чистопородные племенные животные:
итд.
Их необходимо добавить вручную. Для этого создан файл TNVED4.ADD.TXT
