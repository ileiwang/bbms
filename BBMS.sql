DROP DATABASE IF EXISTS bbms;
CREATE DATABASE bbms;
USE bbms;

#管理员表
CREATE TABLE admin(
	id INT(12) NOT NULL AUTO_INCREMENT,
	num VARCHAR(12) NOT NULL,
	name VARCHAR(18) NOT NULL,
	birthday TIMESTAMP NOT NULL,
	idcard VARCHAR(20) NOT NULL,
	sex VARCHAR(5) NOT NULL,
	password VARCHAR(20) NOT NULL,
	tel VARCHAR(20) NOT NULL,
	qq VARCHAR(20) NOT NULL,
	email VARCHAR(30) NOT NULL,
	address VARCHAR(20) NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO admin(num,name,birthday,idcard,sex,password,tel,qq,email,address)
VALUES
('11001','管理员1','1980-01-01 00:00:00','123456197801010001','男','admin','13987698765','1010101','1010101@qq.com','青岛市黄岛区前湾港路579号'),
('11002','管理员2','1981-02-02 00:00:00','123456197801010002','男','admin','13987698766','1010102','1010102@qq.com','青岛市黄岛区前湾港路579号'),
('11003','管理员3','1982-03-03 00:00:00','123456197801010003','男','admin','13987698765','1010103','1010103@qq.com','青岛市黄岛区前湾港路579号'),
('11004','管理员4','1983-04-04 00:00:00','123456197801010004','男','admin','13987698765','1010104','1010104@qq.com','青岛市黄岛区前湾港路579号'),
('11005','管理员5','1984-04-04 00:00:00','123456197801010005','男','admin','13987698765','1010105','1010105@qq.com','青岛市黄岛区前湾港路579号');

#学生表
CREATE TABLE student(
	id INT(12) NOT NULL AUTO_INCREMENT,
	num VARCHAR(18) NOT NULL,
	name VARCHAR(18) NOT NULL,
	birthday TIMESTAMP NOT NULL,
	idcard VARCHAR(20) NOT NULL,
	sex VARCHAR(5) NOT NULL,
	password VARCHAR(20) NOT NULL,
	tel VARCHAR(20) NOT NULL,
	qq VARCHAR(20) NOT NULL,
	email VARCHAR(30) NOT NULL,
	address VARCHAR(20) NOT NULL,
	major VARCHAR(20) NOT NULL,
	college VARCHAR(20) NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO student(num,name,birthday,idcard,sex,password,tel,qq,email,address,major,college)
VALUES
('10001','张三','1997-01-01 00:00:00','123456199701011234','男','admin','17805412345','10001','zhangsan@qq.com','山东科技大学','软件工程','计算机科学与工程学院'),
('10002','李四','1997-02-02 00:00:00','123456199701011235','男','admin','17805412346','10002','lisi@qq.com','山东科技大学','软件工程','计算机科学与工程学院'),
('10003','王五','1997-03-03 00:00:00','123456199701011236','男','admin','17805412347','10003','wangwu@qq.com','山东科技大学','软件工程','计算机科学与工程学院');


#类别表
CREATE TABLE category(
	id INT(12) NOT NULL AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL,
	summary VARCHAR(300) NOT NULL,
	PRIMARY KEY (id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO category(name,summary)
VALUES
('社会科学','社会科学是用科学的方法，研究人类社会的种种现象的各学科总体或其中任一学科。如社会学研究人类社会（主要是当代），政治学研究政治、政策和有关的活动，经济学研究资源分配。社会科学所涵盖的学科包括：经济学、政治学、法学、伦理学、历史学、社会学、心理学、教育学、管理学、人类学、民俗学、新闻学、传播学等。'),
('文学','文学是以语言文字为工具，比较形象化地反映客观现实、表现作家心灵世界的艺术，包括诗歌、散文、小说、剧本、寓言、童话等体裁，是文学的重要表现形式，以不同的形式即体裁，表现内心情感，再现一定时期和一定地域的社会生活。作为学科门类理解的文学，包括中国语言文学、外国语言文学及新闻传播学。'),
('自然科学','自然科学，与“社会科学”、“思维科学”并称“科学三大领域”，它是研究无机自然界和包括人的生物属性在内的有机自然界的各门科学的总称。自然科学是研究大自然中有机或无机的事物和现象的科学，包括天文学、物理学、化学、地球科学、生物学等和地理学。'),
('小说','小说，以刻画人物形象为中心，通过完整的故事情节和环境描写来反映社会生活的文学体裁。'),
('计算机','计算机所相关的技术研究叫计算机科学，以数据为核心的研究称为信息技术。人们把没有安装任何软件的计算机称为裸机。随着科技的发展，现在新出现一些新型计算机有：生物计算机、光子计算机、量子计算机等。'),
('法律','法律，是国家的产物，是指统治阶级（泛指政治、经济、思想形态上占支配地位的阶级），为了实现统治并管理国家的目的，经过一定立法程序，所颁布的基本法律和普通法律。法律是统治阶级意志的体现，国家的统治工具。'),
('人物传记','人物传记是通过对典型人物的生平、生活、精神等领域进行系统描述、介绍的一种文学作品形式。作品要求“真、信、活”，以达到对人物特征和深层精神的表达和反映。人物传记是人物或人物资料的有效记录形式，对历史和时代的变迁等方面的研究具有重要意义。'),
('成功励志','成功励志网专为年轻人精心搜集了大量宝贵的人生经验，通过有趣的故事和生动的说理将其一一展现，以寓意深远的哲理点拨，挖掘人生深层的内涵，向人们阐释了人生的智慧和生活的哲理，让你在轻松阅读中心灵得到陶冶，领悟成功的真谛，把握人生的方向，全面掌控自己的成功人生。'),
('心理学','心理学是一门研究人类心理现象及其影响下的精神功能和行为活动的科学，兼顾突出的理论性和应用（实践）性。心理学包括基础心理学与应用心理学两大领域，其研究涉及知觉、认知、情绪、思维、人格、行为习惯、人际关系、社会关系等许多领域，也与日常生活的许多领域——家庭、教育、健康、社会等发生关联。'),
('艺术','艺术可以是宏观概念也可以是个体现象，通过捕捉与挖掘、感受与分析、整合与运用（形体的组合过程、生物的生命过程、故事的发展过程）通过感受（看、听、嗅、触碰）得到的形式展示出来的阶段性结果。'),
('教育','教育，教育者有目的有计划有组织的对受教育者的心智发展进行教化培育，以现有的经验、学识推敲于人，为其解释各种现象、问题或行为，以增长能力经验，其根本是以人的一种相对成熟或理性的思维来认知对待，让事物得以接近其最根本的存在，人在其中，慢慢的对一种事物由感官触摸而到以认知理解的状态，并形成一种相对完善或理性的自我意识思维。'),
('政治军事','军事（Military） [1]  ，即军队事务，古称军务，是与一个国家及政权的国防之武装力量有关的学问及事务。有人认为，军事为政治的一部分，但在中国古代，军、政是分开的。比较正式的说法为，军事是一种政治延续。'),
('工业技术','工业技术是为达到一定目的，利用自然规律所采取的一系列合理的手段。技术与科学相辅相成。但科学偏重抽象的理论，技术却具体而实用。纯科学理论的概念，不认为是技术。');

#图书表
CREATE TABLE book(
	id INT(12) NOT NULL AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL,
	author VARCHAR(18) NOT NULL,
	publisher VARCHAR(30) NOT NULL,
	isbn VARCHAR(20) NOT NULL,
	year INT(12) NOT NULL,
	words INT(12) NOT NULL,
	coverfilename VARCHAR(30) NOT NULL,
	category_id INT(12) NOT NULL,
	PRIMARY KEY (id),
	KEY FK_BOOK_CATEGORY(category_id),
	CONSTRAINT FK_BOOK_CATEGORY FOREIGN KEY (category_id) REFERENCES category(id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO book(name,author,publisher,isbn,year,words,coverfilename,category_id)
VALUES
('社会学的想象力','C.赖特·米尔斯','北京师范大学出版社（集团）有限公司','978-7-303-21284-2','2017','189000','shxdxxl.jpg','1'),
('反智时代','苏珊·雅各比','新星出版社','9787513330756','2018','35600','fzsd.jpg','1'),
('成为弗洛伊德','亚当·菲利普斯','中国友谊出版公司','9787505742949','2018','256000','cwflyd.jpg','1'),

('希腊神话','施瓦布','北京世图版权代理有限公司','978-7-5117-2640-7','2015','368000','xlsh.jpg','2'),
('雪绒花的庆典','博胡米尔·赫拉巴尔','花城出版社','9787536084476','2018','240000','xrhdqd.jpg','2'),
('一个人的迁徙','白醉','江苏凤凰文艺出版社','9787559410467','2018','306000','ygrdqx.jpg','2'),

('演化的故事','卡尔·齐默','世纪文景 | 上海人民出版社','9787208148710','2018','411000','yhdgs.jpg','3'),
('纸上动物园','夏洛特·斯莱','北京联合出版公司','9787559608406','2018','168000','zsdwy.jpg','3'),
('牛顿的苹果','罗纳德·纳伯斯','中信出版集团','9787508680941','2017','348000','nddpg.jpg','3'),

('绿毛水怪','王小波','北京十月文艺出版社','9787530217948','2018','181000','lmsg.jpg','4'),
('大雪将至','东野圭吾','南海出版公司','9787544258197','2018','184000','dxjz.jpg','4'),
('假面之夜','谢伯让','南海出版公司','9787544292825','2018','416000','jmzy.jpg','4'),

('区块链社会','龚鸣','中信出版社','978-7-122-31259-4','2016','127000','qklsh.jpg','5'),
('终极算法','佩德罗·多明戈斯','中信出版集团','9787508668673','2016','402000','zjsf.jpg','5'),


('法律与宗教','哈罗德 J. 伯尔曼','中国政法大学出版社','9787562022978','2003','204000','flyzj.jpg','6'),
('自由与法律','布鲁诺·莱奥尼','吉林人民出版社','9787206044038','2004','371000','zyyfl.jpg','6'),


('暮色将至','凯蒂·洛芙','中信出版集团','9787508685748','2018','285000','msjz.jpg','7'),
('奥古斯都','阿德里安·戈兹沃西','社会科学文献出版社','9787509792445','2016','695000','agsd.jpg','7'),


('个体崛起','陈立飞','湖南文艺出版社','9787540483197','2017','264000','gtjq.jpg','8'),
('如何做个成功者','MICHAELW.MERCER','中国轻工业出版社','9787501924967','1999','209000','rhzgcgz.jpg','8'),


('思维的发现','迈克尔•刘易斯','中信出版社','9787508689265','2018','375000','swdfx.jpg','9'),
('科学学习','丹尼尔 L. 施瓦茨','机械工业出版社','9787111597995','2018','127000','kxxx.jpg','9'),


('论新','鲍里斯·格罗伊斯','拜德雅 | 重庆大学出版社','9787568905237','2018','216000','lx.jpg','10'),
('蒙娜丽莎发现史','黛安娜·黑尔斯','浙江大学出版社·启真馆','9787308171793','2018','368000','mnlsfxs.jpg','10'),


('陶哲轩教你学数学','陶哲轩','人民邮电出版社','9787115468949','2017','171000','tzxjnxsx.jpg','11'),
('新华字典','中国社会科学院语言研究所','商务印书馆','9787100077040','2011','711000','xhzd.jpg','11'),


('解放的悖论','迈克尔·沃尔泽','三辉图书/商务印书馆','9787100146654','2017','168000','jfdbl.jpg','12'),
('记忆','埃里克·沃格林','华东师范大学出版社','9787567565241','2017','127000','jy.jpg','12'),


('创客:新工业革命','克里斯·安德森','中信出版社','9787508651675','2015','360000','xgygm.jpg','13'),
('第四次工业革命','克劳斯·施瓦布','中信出版集团股份有限公司','9787508661254','2016','224000','dscgygm.jpg','13');


#借阅记录表
CREATE TABLE borrow(
	id INT(12) NOT NULL AUTO_INCREMENT,
	student_id INT(30) NOT NULL,
	book_id INT(30) NOT NULL,
	borrowtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	backtime TIMESTAMP NOT NULL,
	isback INT(2) NOT NULL DEFAULT '0',
	PRIMARY KEY (id),
	KEY FK_BORROW_STUDENT(student_id),
	KEY FK_BORROW_BOOK(book_id),
	CONSTRAINT FK_BORROW_STUDENT FOREIGN KEY (student_id) REFERENCES student(id),
	CONSTRAINT FK_BORROW_BOOK FOREIGN KEY (book_id) REFERENCES book(id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO borrow(student_id,book_id)
VALUES
('1','1'),
('1','2'),
('1','3'),
('1','4'),
('1','5'),
('2','6'),
('2','7'),
('2','8');


#图书评论表
CREATE TABLE remark(
	id INT(12) NOT NULL AUTO_INCREMENT,
	title VARCHAR(20) NOT NULL,
	content VARCHAR(200) NOT NULL,
	student_id INT(30) NOT NULL,
	book_id INT(30) NOT NULL,
	rtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
	KEY FK_REMARK_STUDENT(student_id),
	KEY FK_REMARK_BOOK(book_id),
	CONSTRAINT FK_REMARK_STUDENT FOREIGN KEY (student_id) REFERENCES student(id),
	CONSTRAINT FK_REMARK_BOOK FOREIGN KEY (book_id) REFERENCES book(id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO remark(title,content,student_id,book_id)
VALUES
('写的不错','社会学的想象力的评论！','1','1'),
('写的不错','希腊神话的评论！','1','2'),
('写的不错','大脑简史的评论！','1','3'),
('一本好书','知识工程与创新的评论','2','4'),
('蒙娜丽莎发现史','蒙娜丽莎是谁？她生活在哪里？有着怎样的一生？','1','24'),
('论新','·杜尚的《泉》、马勒维奇的《黑方块》、蒙德里安的格子画……这些艺术作品的创新究竟有何意义？它们的文化价值究竟从哪儿来？','1','23'),
('陶哲轩教你学数学','本书是国际知名数学家陶哲轩15岁时的著作，从青少年的角度分析数学问题，主要是数学竞赛等智力谜题，用学生的语言解释思考过程，完整展现了少年陶哲轩的解题思路','1','25'),
('新华字典','释义准确，例证精当，内容丰富，简明实用','1','26'),
('记忆','《记忆》（Anamnesis）一书在沃格林的智识生涯中，地位相当独特。','1','27'),
('解放的悖论','“二战”后，扎根“民主”等世俗理念的民族解放运动在世界范围内风起云涌，然而一旦实现民族独立，新创设的国家制度与原则总会不可避免地面临来自宗教领域超乎寻常的激烈反扑。','1','28'),
('创客:新工业革命','这是一场即将到来的革命，也是一场有可能引领中国产业大变革的革命。','1','29'),
('第四次工业革命','蒸汽机的发明驱动了第一次工业革命，流水线作业和电力的使用引发了第二次工业革命，半导体、计算机、互联网的发明和应用催生了第三次工业革命','1','30');

#想读图书表
CREATE TABLE wishbook(
	id INT(12) NOT NULL AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	author VARCHAR(20) NOT NULL,
	student_id INT(10) NOT NULL,
	PRIMARY KEY (id),
	KEY FK_REMARK_STUDENT(student_id),
	CONSTRAINT FK_WISHBOOK_STUDENT FOREIGN KEY (student_id) REFERENCES student(id)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO wishbook(name,author,student_id)
VALUES
('西游记','吴承恩','1'),
('红楼梦','曹雪芹','1'),
('三国演义','罗贯中','1'),
('水浒传','施耐庵','2');