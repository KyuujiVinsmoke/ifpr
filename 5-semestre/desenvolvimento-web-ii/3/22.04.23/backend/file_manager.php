<?php

    function read() {

        $pessoas = array();
        $fp = fopen('../bd/pessoas.txt', 'r');

        if ($fp) {

            while(!feof($fp)) {
                $arr = array();
                $cpf = str_replace("\n", "", fgets($fp));
                $dados = str_replace("\n", "", fgets($fp));
                if(!empty($dados)) {
                    $arr = explode("#", $dados);
                    $pessoas[$cpf] = $arr;
                }
            }

            fclose($fp);
            return $pessoas;
        }
    }

    function create($pessoas) {

        if(isset($_POST['cpf'])) {
            $cpf = $_POST['cpf'];
            $nome = $_POST['nome'];
            $ender = $_POST['ender'];
            $tel = $_POST['tel'];
            $arr = array($nome, $ender, $tel);
    
            $pessoas[$cpf] = $arr;
        } else if($_POST['cpf-edit']) {
            $cpf = $_POST['cpf-edit'];
            $nome = $_POST['nome'];
            $ender = $_POST['ender'];
            $tel = $_POST['tel'];
            $arr = array($nome, $ender, $tel);
    
            $pessoas[$cpf] = $arr;
        }


        if(isset($_POST['cpf-edit'])) {
            $nome = $_POST['nome'];
            $ender = $_POST['ender'];
            $tel = $_POST['tel'];

            $arr = array($nome, $ender, $tel);

            $pessoas[$cpf] = $arr;
        }

        $fp = fopen('../bd/pessoas.txt', "w");

        if ($fp) {

            foreach($pessoas as $cpf_p => $dados) {

                fputs($fp, "$cpf_p\n");
                
                $linha = $dados[0]."#".$dados[1]."#".$dados[2];
                
                fputs($fp, "$linha\n");
            }

        } else {
            echo "<script>alert('SUBMIT - ERROR')</script>";
        }
        
        fclose($fp);
        header("Location: frontend/read.php");
    }

    function delete($chave) {

        $pessoas = read();

        unset($pessoas[$chave]);

        create($pessoas);
        
    }

    function findyPessoa($chave) {
        $pessoas = read();

        return $pessoas[$chave];
    }
?>