import './login.css'

import {Logo} from '../../components/Logo'

import { useState } from 'react'
import {auth} from '../../services/firebaseConnection'
import {signInWithEmailAndPassword} from 'firebase/auth'
import {useNavigate} from 'react-router-dom'

import {toast} from 'react-toastify'


export default function Login(){

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const navigate = useNavigate();

    function handleLogin(e){
        e.preventDefault();
        if(email === '' || password ===''){
            alert("Preencha todos os campos!")
        }

        signInWithEmailAndPassword(auth, email, password)
        .then(() => {
            toast.success("Aee, conseguiu entrar, bem vindo de volta")
            navigate("/admin", {replace: true})

           
        })
        .catch(() => {
            toast.error("Esqueceu a senha de novo ?")
        })


    }

    return(
        <div className="login-container">
            <Logo/>

            <form className="form" onSubmit={handleLogin}>
                <input 
                    type="email"
                    placeholder="Digite seu e-mail"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                />

                <input 
                    type="password"
                    placeholder="********"
                    autoComplete="on"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />

                <button type="submit"> Acessar</button>

            </form>
           
        </div>
    )
}