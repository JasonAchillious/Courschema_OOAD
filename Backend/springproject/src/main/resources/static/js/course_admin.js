new Vue({
    el: "#courseDesc",
    data: {
        courses: [],
        showTable: [],
        departments: [],
        currentPage: 1,
        loading: true,
        totalPages: 1,
        showNum: 0,
        currentDepart: '计算机科学与技术',
        currentYear: 1,
        courseNum: 0,

        modalChineseName: "",
        modalBianHao: "",
        modalIntro: "",
        modalCredit: '',
        modalTerm: '',
        modalYear: "",
        modalDepartments: "",
        modalEnglishName: "",
        modalXianxiu: "",

        userId: 11711335,


        isUpdate: false,
        updateIdCourse: -1,
        updateChineseName: "",
        updateBianHao: "",
        updateIntro: "",
        updateCredit: 3,
        updateSpring: true,
        updateAutumn: false,
        updateSummer: false,
        updateIntro: "",
        updateYear: 1,
        updateDepartments: "",
        updateEnglishName: "",

    },

    methods: {
        select: function (n) {
            if (n === this.currentPage) return
            if (typeof n === 'string') return
            this.currentPage = n
        },

        prevOrNext: function (n) {
            this.currentPage += n
            this.currentPage < 1 ?
                this.currentPage = 1 :
                this.currentPage > this.totalPages ?
                    this.currentPage = this.totalPages :
                    null
        },

        isNull(str) {
            if (str == "") {
                return true;
            }
            var regu = "^[ ]+$";
            var re = new RegExp(regu);
            return re.test(str);
        },

        generateYear(course) {
            if (course == null) {
                console.log("课程不存在")
                return "该课程不存在";
            }
            _year = '';

            switch (course.year) {
                case 1:
                    _year = "大一";
                    break;
                case 2:
                    _year = "大二";
                    break;
                case 3:
                    _year = "大三";
                    break;
                case 4:
                    _year = "大四";

                default:
                    _year = " ";
            }
            return _year;
        },

        setCurrentYear(year) {
            this.currentYear = year;
        },

        setCurrentDepart(depart) {
            this.currentDepart = depart;
        },

        // deepCopy = function (obj) {
        //     // 只拷贝对象
        //     if (typeof obj !== 'object') return;
        //     // 根据obj的类型判断是新建一个数组还是一个对象
        //     var newObj = obj instanceof Array ? [] : {};
        //     for (var key in obj) {
        //         // 遍历obj,并且判断是obj的属性才拷贝
        //         if (obj.hasOwnProperty(key)) {
        //             // 判断属性值的类型，如果是对象递归调用深拷贝
        //             newObj[key] = typeof obj[key] === 'object' ? deepCopy(obj[key]) : obj[key];
        //         }
        //     }
        //     return newObj;
        // }
        generateTerm(course) {
            _term = "";
            if (course.spring) {
                _term += "/春季期";
            }
            if (course.autumn) {
                _term += "/秋季期";
            }
            if (course.summer) {
                _term += "/夏季小学期"
            }

            if (_term === "") {
                return "已停止开设";
            } else {
                _term[1] = " ";
                return _term;
            }
        },

        setModalcontent(course) {
            this.modalTerm = this.generateTerm(course);
            this.modalChineseName = course.chineseName;
            this.modalBianHao = course.BianHao;
            this.modalIntro = course.intro;
            this.modalCredit = course.credit;
            this.modalYear = this.generateYear(course);
            this.modalDepartments = course.departments;
            this.modalEnglishName = course.englishName;
            this.modalXianxiu = course.englishName;

            $('#courseInfo').modal('show')
        },

        updateCourse(){
            console.log(this.updateBianHao)
            console.log(this.updateAutumn)

        },

        addCourse(){

        },

        updateModalOn(){
            this.isUpdate = true
            this.clearModal()
            $('#editCourse').modal('show')
        },

        addModelOn(){
            this.isUpdate = false
            this.clearModal()
            $('#editCourse').modal('show')
        },

        deleteCourse(){

        },

        clearModal(){
            this.modalChineseName=""
            this.modalBianHao=""
            this.modalIntro=""
            this.modalCredit=''
            this.modalTerm=''
            this.modalYear=""
            this.modalDepartments=""
            this.modalEnglishName=""
            this.modalXianxiu=""
        }

    },

    watch: {
        courses: {
            handler(){
                if (this.courses == null) {
                    this.courseNum = 0;
                } else {
                    this.courseNum = this.courses.length;
                }

            },
            immediate: true,
            deep: true
        },

        showTable: {
            handler(newShowTable, oldShowTable) {
                if (this.showTable == null) {
                    this.showNum = 0;
                } else {
                    this.showNum = this.showTable.length;
                }

                if (this.showNum == 0) {
                    this.totalPages = 1;
                } else {
                    this.totalPages = Math.ceil(this.showNum / 10);
                }
            },

            immediate: true,
            deep: true
        },

        currentYear: {
            handler() {
                this.loading = true;
                console.log(1111)
                this.showTable.slice(0, this.showTable.length);
                console.log(22222)
                for (var i = 0; i < this.courseNum; i++) {
                    console.log(333333333)
                    if (this.courses[i].departments === this.currentMajor && this.courses[i].year === this.currentYear) {
                        this.showTable.push(this.courses[i]);

                    }
                }
                this.loading = false;
            },
            immediate: true
        },
        currentMajor: {
            handler() {
                console.log(6666)
                this.loading = true;
                this.showTable.slice(0, this.showTable.length);
                console.log(7777)
                for (var i = 0; i < this.courseNum; i++) {
                    console.log(123456)
                    if (this.courses[i].departments == this.currentMajor && this.courses[i].year == this.currentYear) {
                        this.showTable.push(this.courses[i]);
                        console.log(2222222222)
                    }
                }
                this.loading = false;
            },
            immediate: true
        }
    },

    computed: {

        pages() {
            const c = this.currentPage;
            const t = this.totalPages;
            if (t <= 10) {
                var foo = [];
                for (var i = 1; i <= t; i++) {
                    foo.push(i);
                }
                return foo;
            } else if (c <= 5) {
                return [1, 2, 3, 4, 5, 6, 7, 8, 9, '...', t]
            } else if (c >= t - 4) {
                return [1, '...', t - 8, t - 7, t - 6, t - 5, t - 4, t - 3, t - 2, t - 1, t]
            } else {
                return [1, '...', c - 3, c - 2, c - 1, c, c + 1, c + 2, c + 3, '...', t]
            }
        },

        computeIndex() {
            const c = this.currentPage;
            var s = (c - 1) * 10;
            var e = (c - 1) * 10 + 9;
            if (e > this.showTable.length - 1) {
                e = this.showTable.length - 1;
            }
            var foo = [];
            for (var i = s; i <= e; i++) {
                foo.push(i);
            }

            return foo
        },

        // setShowTable() {
        //     const _year = this.currentYear;
        //     const _major = this.currentMajor;
        //     const courseList = this.courses;
        //     for (course in courseList) {
        //         if (course.major === _major && course.year === _year) {
        //             this.showTable.push(course);
        //         }
        //     }
        // }
    },
    mounted: function () {
        axios
            .post('/allcourse', {})
            .then(response => {
                this.courses = response.data
                console.log(this.courses)
            })
            .catch(error => {
                console.log(error)
                alert("未知错误， 请联系相关负责人员")
            })
            .finally(() => {
                this.loading = false;
                console.log(this.loading)
            })

        axios
            .post("department/findAllDepartmentAndMajor", {userId: 11711335})
            .then(response => {
                this.departments = response.data
                console.log(this.departments)
            })
            .catch(error => {
                console.log(error)
                alert("未知错误， 请联系相关负责人员")
            })

    },

})