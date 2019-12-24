
// sidebar
var majorData = {
    dataId: "ec1",
    colleges: [
        {
            name: "理学院",
            departments: [
                {
                    name: "数学系",
                    majors: [
                        { name: "数学与应用数学" },
                        { name: "统计学" },
                        { name: "金融数学" }
                    ]
                },

                {
                    name: "物理系",
                    majors: [
                        { name: "物理学" },
                        { name: "应用物理学" }
                    ]
                }
            ]
        },
        {
            name: "工学院",
            departments: [
                {
                    name: "计算机科学与工程",
                    majors: [
                        { name: "计算机科学与技术" },
                        { name: "智能科学与技术" }
                    ]
                }
            ]
        },
        {
            name: "商学院",
            departments: [
                {
                    name: "金融系",
                    majors: [
                        { name: "金融学" },
                        { name: "金融工程" }
                    ]
                }
            ]
        }
    ]
};

new Vue({
    el: '#majorList',
    data: majorData
})

$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
});

// Course text Infomation
var textData = {
    paragraphs: [
        {
            title: "计算机科学与技术培养方案",
            text: "计算机科学具有极广阔的发展前景，也是人才严重短缺的专业之一。伴随着计算机技术的突飞猛进及企业的现代化，计算机人才的短缺现象将会越来越严重。由于计算机技术的高新、密集和渗透，以及与其他学科的交叉、技术创新、市场的激烈竞争，决定了当前和今后一段时期内，迫切需要高层次，复合型、创新性、高素质的应用型人才。"
        }
    ]
}

new Vue({
    el: '#programText',
    data: textData
})

// Course Table 

var theadData = {
    courseID: "课程编号",
    courseName: "课程名称",
    courseScore: "学分",
    experimentScore: "实验学分",
    weekLearningTime: "周学时",
    SetTerm: "开课学期",
    AdviceTerm: "建议修课学期",
    courseLang: "授课语言",
    preCourse: "先修课程",
    institute: "开课院系"
}

var testData = {
    courseID: "Test123",
    courseName: "OOAD",
    courseScore: "3",
    experimentScore: "1",
    weekLearningTime: "3",
    SetTerm: "春",
    AdviceTerm: "大三",
    courseLang: "English",
    preCourse: "数据库系统原理",
    institute: "CS",

}

var tbodyData = {
    courses: [
        { courseInfo: testData, courseType: "专业核心课" },
        { courseInfo: testData, courseType: "专业先修课" },
        { courseInfo: testData, courseType: "专业基础课" }
    ]
}


new Vue({
    el: "#courseTable",
    data: {
        theader: theadData,
        tbody: tbodyData,
    },
    /*mounted() {
        axios
            .get('url')
            .then(response => (this.tbody = response))
            .catch(function (error) { // 请求失败处理
                console.log(error);
            });
    }*/
    methods: {
        update: function (url) {
            axios
                .get(url)
                .then(response => (this.tbody = response))
                .catch(function (error) { // 请求失败处理
                    console.log(error);
                });
                alert(response)
        }
    }
})
