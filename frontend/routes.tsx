import TaskView from "Frontend/views/task/TaskView";
import SolutionView from 'Frontend/views/solution/SolutionView';
import MainLayout from 'Frontend/views/MainLayout.js';
import {createBrowserRouter, RouteObject} from 'react-router-dom';

export const routes = [
    {
        element: <MainLayout/>,
        handle: {title: 'Main'},
        children: [
            {path: '/', element: <TaskView/>, handle: {title: 'Task View'}},
            {path: '/solution', element: <SolutionView/>, handle: {title: 'Solution View'}},
        ],
    },
] as RouteObject[];

export default createBrowserRouter(routes);
