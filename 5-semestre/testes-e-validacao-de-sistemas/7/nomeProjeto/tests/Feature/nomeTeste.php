<?php

namespace Tests\Feature;

use Illuminate\Foundation\Testing\RefreshDatabase;
use Illuminate\Foundation\Testing\WithFaker;
use Tests\TestCase;

class nomeTeste extends TestCase
{
    public function test_example()
    {   
        /** Ação */
        $response = $this->get('/');

        /** Verificação */
        $response->assertStatus(200);
    }
}
