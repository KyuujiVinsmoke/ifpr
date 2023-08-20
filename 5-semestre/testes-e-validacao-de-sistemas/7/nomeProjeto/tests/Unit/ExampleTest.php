<?php

namespace Tests\Unit;

use PHPUnit\Framework\TestCase;
use App\Models\User;

class ExampleTest extends TestCase
{
    public function test_that_true_is_true()
    {   
         /** Verificação */
        $this->assertTrue(true);
    }

    public function testaVerificarColunasUsuarios()
    {
        /** Cenário */
        $user = new User;
        $expected = [
            'name',
            'email',
            'password'
        ];

        /** Ação */
        $arrayCompared = array_diff($expected, $user->getFillable());

        /** Verificação */
        $this->assertEquals(0, count($arrayCompared));
    }
}
