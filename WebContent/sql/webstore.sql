

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(255) DEFAULT NULL,
  `book_author` varchar(255) DEFAULT NULL,
  `book_typeid` varchar(255) DEFAULT NULL,
  `book_sprice` decimal(10,0) DEFAULT NULL,
  `book_remark` varchar(255) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `book_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '三体', '【中】刘慈欣', '1', '56', '全三册 刘慈欣代表作，亚洲首部“雨果奖”获奖作品！', 'img/三体.jpg', '22');
INSERT INTO `book` VALUES ('2', '孤独深处', '【中】郝景芳', '1', '35', '2016雨果奖获得者郝景芳作品，收录《北京折叠》，中国科幻又一高峰！', 'img/孤独深处.jpg', '22');
INSERT INTO `book` VALUES ('3', '银河帝国：基地', '【美】阿西莫夫', '1', '35', '被马斯克用火箭送上太空的科幻神作，讲述人类未来两万年的历史。', 'img/银河帝国：基地.jpg', '22');
INSERT INTO `book` VALUES ('4', '星尘', '【英】尼尔·盖曼', '1', '40', '一部畅销20年的浪漫奇幻经典，作者入围2018年新文学院奖终选', 'img/星尘.jpg', '22');
INSERT INTO `book` VALUES ('6', '美丽新世界', '【英】阿道司·赫胥黎', '1', '32', '精装插图纪念版，兰登书屋百佳英文小说，欧美中学生必读书目', 'img/美丽新世界.jpg', '22');
INSERT INTO `book` VALUES ('7', '好兆头', '【英】特里·普拉切特', '1', '60', '两大重磅奇幻作家强强联手！作者入围2018年新文学院奖终选', 'img/好兆头.jpg', '22');
INSERT INTO `book` VALUES ('8', '神秘岛', '【法】儒勒凡尔纳', '1', '32', '“科幻小说之父”凡尔纳海洋三部曲终结篇，世界科幻小说经典之作！', 'img/神秘岛.jpg', '22');
INSERT INTO `book` VALUES ('11', '巨人的陨落', '【法】肯·福莱特', '2', '129', '通宵小说大师肯·福莱特世纪三部曲，全球读者平均三个通宵读完！以恢宏辽阔、荡气回肠的故事全景展现整个20世纪人类史。', 'img/巨人的陨落.jpg', '22');
INSERT INTO `book` VALUES ('12', '曾国藩', '【中】唐浩明', '2', '100', '受中央国家机关干部欢迎的10本书之一、中纪委推荐干部必读书目。宗庆后、柳传志等商界传奇联袂推荐！一部展现中国式处世智慧的作品。', 'img/曾国藩.jpg', '22');
INSERT INTO `book` VALUES ('13', '圣殿春秋', '【法】肯·福莱特', '2', '188', '通宵小说大师肯·福莱特中世纪三部曲，欧美读者平均3个通宵读完！', 'img/圣殿春秋.jpg', '22');
INSERT INTO `book` VALUES ('14', '大明王朝1566', '【中】刘和平', '2', '58', '官家看方略,小民读命运,学界寻国脉！古代政治的原型标本,当代官场的历史启示', 'img/大明王朝1566.jpg', '22');
INSERT INTO `book` VALUES ('15', '无尽世界', '【法】肯·福莱特', '2', '188', '通宵小说大师肯·福莱特中世纪三部曲，欧美读者平均3个通宵读完！', 'img/无尽世界.jpg', '22');
INSERT INTO `book` VALUES ('16', '世界的凛冬', '【法】肯·福莱特', '2', '132', '通宵小说大师肯·福莱特中世纪三部曲，欧美读者平均3个通宵读完！', 'img/世界的凛冬.jpg', '22');
INSERT INTO `book` VALUES ('17', '胡雪岩全传', '【中】高阳', '2', '359', '讲透一代商圣胡雪岩的天才与宿命，影响中国一代企业家的经典！马云读了两遍，强烈推荐', 'img/胡雪岩全传.jpg', '22');
INSERT INTO `book` VALUES ('18', '康熙大帝', '【中】二月河', '2', '110', '二月河历史小说巨作，用小说呈现盛世帝国的清朝版《追问》，深度反思千年中国的吏治与反腐问题，为当下中国的反腐提供镜鉴。', 'img/康熙大帝.jpg', '22');
INSERT INTO `book` VALUES ('19', '楼兰', '【日】井上靖', '2', '25', '早已消失在黄沙尽头的楼兰，正在井上靖笔下得以复活！', 'img/楼兰.jpg', '22');
INSERT INTO `book` VALUES ('20', '春秋战国', '【中】胡晓明', '2', '130', '看风云际会，春秋五霸争问鼎；看纵横捭阖，战国七雄竞逐鹿。伟大的人物，铸就伟大的时代！春秋的思想、战国的计谋，至今依然深刻地影响着每一个中国人的思维方式和生活习惯。', 'img/春秋战国.jpg', '22');
INSERT INTO `book` VALUES ('21', '挪威的森林', '【日】村上春树', '3', '48', '村上春树影响几代读者的畅销青春名作，特有的感伤和孤独', 'img/挪威的森林.jpg', '22');
INSERT INTO `book` VALUES ('22', '狼图腾', '【中】姜戎', '3', '40', '一部描绘、研究蒙古草原狼的“旷世奇书”', 'img/狼图腾.jpg', '22');
INSERT INTO `book` VALUES ('23', '外婆的道歉信', '【瑞典】弗雷德里克·巴克曼', '3', '24', '年度口碑爆棚的温情小说', 'img/外婆的道歉信.jpg', '22');
INSERT INTO `book` VALUES ('24', '围城', '【中】钱钟书', '3', '39', '婚姻是一座围城，外面的人想进去，里面的人想出来', 'img/围城.jpg', '22');
INSERT INTO `book` VALUES ('25', '景恒街', '【中】笛安', '3', '50', '我要写一个爱情故事，一个关于当下的，成年人之间的爱情故事。', 'img/景恒街.jpg', '22');
INSERT INTO `book` VALUES ('26', '清单人生', '【瑞典】弗雷德里克·巴克曼', '3', '42', '也许你读过《外婆的道歉信》，那你一定知道我说的，读完后大哭着笑或者大笑着哭的感觉。', 'img/清单人生.jpg', '22');
INSERT INTO `book` VALUES ('27', '从你的全世界路过', '【中】张嘉佳', '3', '56', '6 个月，畅销200万册，超会讲故事的人张嘉佳，献给你的心动故事！ 14亿次阅读， 1500 万次转发', 'img/从你的全世界路过.jpg', '22');
INSERT INTO `book` VALUES ('28', '漫长的告别', '【法】雷蒙德·钱德勒', '3', '32', '这是真正意义上的灵魂交流的故事，是人与人之间自发地相互理解的故事，是人类抱有的美好幻想和它不可避免地引发的深深幻灭的故事', 'img/漫长的告别.jpg', '22');
INSERT INTO `book` VALUES ('29', '岛', '【英】希洛普斯', '3', '57', '★2006年英国畅销书top1 ★在大书云集的2006年，新人处女作《岛》凭借作品的实力，一举超越《达芬奇密码》《追风筝的人》《哈利波特6》，荣登英国畅销书排行榜冠军宝座。', 'img/岛.jpg', '22');
INSERT INTO `book` VALUES ('30', '不能承受的生命之轻', '【英】米兰昆德', '3', '46', '《不能承受的生命之轻》是捷克斯洛伐克小说家米兰 昆德拉*负盛名的作品之一。小说描写了托马斯与特丽莎、萨丽娜之间的感情生活。', 'img/不能承受的生命之轻.jpg', '22');
INSERT INTO `book` VALUES ('31', '非暴力沟通', '【美】卢森堡', '4', '33', '著名的马歇尔 卢森堡博士发现了神奇而平和的非暴力沟通方式，通过非暴力沟通，世界各地无数的人们获得了爱、和谐和幸福！当我们褪去隐蔽的精神暴力，爱将自然流露。', 'img/非暴力沟通.jpg', '22');
INSERT INTO `book` VALUES ('32', '生活需要仪式感', '【中】李思圆', '4', '36', '青年作家李思圆重磅新作，写给有心改变却失去方向的人。', 'img/生活需要仪式感.jpg', '22');
INSERT INTO `book` VALUES ('33', '高效能人士的七个习惯', '【美】史蒂芬·柯维', '4', '79', '高效能人士的七个习惯（30周年纪念版）》亮点 1、非凡著作，全新修订，精彩呈现，畅销30载。', 'img/高效率人士的七个习惯.jpg', '22');
INSERT INTO `book` VALUES ('34', '亲密关系：通往灵魂的桥梁', '【美】克里斯多福·孟', '4', '35', '★国际演说家、生命教练和咨商师克里斯多福 孟经典作品。 ★华语世界深具影响力身心灵作家张德芬翻译并全力推荐。 ', 'img/亲密关系：通往灵魂的桥梁.jpg', '22');
INSERT INTO `book` VALUES ('35', '好看的皮囊千篇一律', '【中】老杨的猫头鹰', '4', '40', '送给对生活用心太少，对别人用力太多的人。 专治生活干巴、良心脆弱等疑难杂症。 长得一般般，却有着谜一般的自信从容，心里话常常是： 也不知道，这么优秀的我，以后会便宜了谁 。', 'img/好看的皮囊千篇一律.jpg', '22');
INSERT INTO `book` VALUES ('36', '人性的弱点', '【美】戴尔·卡耐基', '4', '59', '特别收录市面罕见的《创造奇迹的信》及《幸福家庭生活的七个法则》，全球第二大畅销书，销量仅次于《圣经》。被视为社交心理和沟通技巧的至高宝典。', 'img/人性的弱点.jpg', '22');
INSERT INTO `book` VALUES ('37', '好好说话', '【中】马薇薇、邱晨', '4', '37', '★生活处处给你下套，会说话才能脱身。怎么把话说到别人心坎里，zui短的时间解决你zui痛的说话难题。', 'img/好好说话.jpg', '22');
INSERT INTO `book` VALUES ('38', '我这么自律，就是为了不平庸至死', '【中】怀左同学', '4', '38', '“简书励志写作新偶像”怀左同学重磅新作，简书14万喜欢，全平台阅读10亿+，人民日报/新华社多次转载、彭小六感动推荐。从自律到写作，120000字肺腑之言、经验之谈，写给所有心怀梦想，不惧未来的你我', 'img/我这么自律就是为了不平庸至死.png', '22');
INSERT INTO `book` VALUES ('39', '认知·天性', '【美】彼得·布朗', '4', '45', '亚马逊年度学习畅销书，连续5年高居心理认知榜单Top1。樊登读书会、简单心理、TED中国引进者联合推荐。《认知天性:让学习轻而易举的心理学规律》这本书是11位认知心理学家10年的科研心血。以', 'img/认知·天性.jpg', '22');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `book_id` varchar(255) DEFAULT NULL,
  `book_name` varchar(255) DEFAULT NULL,
  `order_count` int(11) DEFAULT NULL,
  `order_price` decimal(10,0) DEFAULT NULL,
  `order_time` varchar(255) DEFAULT NULL,
  `order_statu` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('67', '6', '邹金霖', '11', '巨人的陨落', '1', '129', '2018-12-29 00:50:37', '到货');
INSERT INTO `order` VALUES ('68', '6', '邹金霖', '2', '孤独深处', '1', '35', '2018-12-29 00:50:37', '发货');
INSERT INTO `order` VALUES ('69', '6', '邹金霖', '3', '银河帝国：基地', '1', '35', '2018-12-29 00:50:37', '到货');
INSERT INTO `order` VALUES ('70', '6', '邹金霖', '4', '星尘', '1', '40', '2018-12-29 00:50:37', '下单');
INSERT INTO `order` VALUES ('71', '6', '邹金霖', '3', '银河帝国：基地', '1', '35', '2018-12-29 08:17:03', '下单');
INSERT INTO `order` VALUES ('72', '6', '邹金霖', '4', '星尘', '1', '40', '2018-12-29 08:17:03', '下单');
INSERT INTO `order` VALUES ('73', '6', '邹金霖', '2', '孤独深处', '1', '35', '2018-12-29 08:17:03', '下单');
INSERT INTO `order` VALUES ('74', '6', '邹金霖', '1', '三体', '1', '56', '2018-12-29 08:17:03', '下单');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '小说');
INSERT INTO `type` VALUES ('2', '历史');
INSERT INTO `type` VALUES ('3', '情感');
INSERT INTO `type` VALUES ('4', '励志故事');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_level_id` int(11) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '0', 'admin', '123456');
INSERT INTO `user` VALUES ('2', '1', '黄三炮', '123456');
INSERT INTO `user` VALUES ('5', '1', '123', '123456');
INSERT INTO `user` VALUES ('6', '1', '邹金霖', '123');
