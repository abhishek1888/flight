import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.jsx'
import './index.css'
import {createBrowserRouter,RouterProvider} from 'react-router-dom';
import {Addflight} from './component/Addflight';
import 'bootstrap/dist/css/bootstrap.min.css'
const router=createBrowserRouter(
  [
    {
         path:"/",
         element:<App/>
    },
    {
        path:"/add",
        element:<Addflight/>
        
    },
    {
      path:"/update/:fnumber",
      element:<Addflight/>
    }
  ]
)
ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
   <RouterProvider router={router}>
   </RouterProvider>
  </React.StrictMode>,
)
