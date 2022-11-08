import express, { Request, Response } from "express";

const app = express();
app.use(express.json()); // se koristi za da moze req.body da ima vrednost i da ne bide undefined.
const port = 3000;

type Course = {
  id: number;
  name: string;
  professor: string;
};

const courses: Course[] = [
  {
    id: 0,
    name: "Web programiranje",
    professor: "Anastas Misev",
  },
  {
    id: 1,
    name: "Verojatnost i Statistika",
    professor: "APM - Aleksanda Popovska Mitrovska",
  },
  {
    id: 2,
    name: "Administracija na bazi na podatoci",
    professor: "Vangel Ajanovski",
  },
];

app.get("/courses", (req: any, res: any) => {
  res.json(courses);
});

app.get("/courses/:id", (req: any, res: any) => {
  const courseId: number = req.params.id;
  const foundCourse = courses.find((course) => course.id == courseId);
  console.log(foundCourse);
  if (foundCourse == null) {
    res.send("Course not found 404");
  }
  res.json(foundCourse);
});

app.post("/courses", (req: Request, res: Response) => {
  const newCourse = req.body as Course;
  newCourse.id = courses.length + 1;
  courses.push(newCourse);

  res.json(newCourse);
});

app.listen(port, () => {
  console.log("Listening on port", port);
});
