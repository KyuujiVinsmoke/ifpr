import './home.css'

import {Social} from '../../components/Social'
import {FaFacebook, FaInstagram, FaYoutube, FaLinkedinIn, FaGithub} from 'react-icons/fa'
import {RiMailSendLine} from 'react-icons/ri'


export default function Home(){
    return(
        <div className="home-container">
            <img src="https://scontent.ffln5-1.fna.fbcdn.net/v/t1.6435-9/32911351_1057670174385608_6649884983789879296_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=174925&_nc_ohc=D7ei89GhMG0AX_ZbSTL&tn=63idZkAhzph6PUgh&_nc_ht=scontent.ffln5-1.fna&oh=00_AfB-vMfT_bokz14AQWdxYvMUdC32sgJfJJOxiAoOH-3QFA&oe=63931594"></img>
            <h1>Luccas Kayure</h1>
            <span>Meus links </span>

            <main className="links">
                <section className="link-area">
                    <a href="#">
                        <p>Canal Youtube</p>
                    </a>
                </section>

                <section className="link-area">
                    <a href="#">
                        <p>Projetos Desenvolvidos</p>
                    </a>
                </section>

                <section className="link-area">
                    <a href="#">
                        <p>Certificações</p>
                    </a>
                </section>

                <footer>
                <a href = "mailto:luccas_kayure@hotmail.com" target="_blank"></a>
                    
                    <Social url="https://www.facebook.com/kayureex">
                        <FaInstagram size={35} color="#FFF"/>                        
                    </Social>
                    <Social url="https://www.linkedin.com/in/luccas-kayure/">
                        <FaLinkedinIn size={35} color="#FFF"/>                        
                    </Social>
                    <Social url="https://github.com/Kayure">
                        <FaGithub size={35} color="#FFF"/>                        
                    </Social> 
                    <Social url = "mailto:luccas_kayure@hotmail.com" target="_blank" >
                        <RiMailSendLine size={35} color="#FFF"/>                        
                    </Social> 
                </footer>
            </main>
        </div>
    )
}