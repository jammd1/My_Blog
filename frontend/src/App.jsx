import {Route, Routes} from "react-router";
import Home from "./Home.jsx";
import PostDetail from "./PostDetail.jsx";

function App() {
  return (
      <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/posts/:postId" element={<PostDetail/>}/>
      </Routes>
  )
}

export default App
