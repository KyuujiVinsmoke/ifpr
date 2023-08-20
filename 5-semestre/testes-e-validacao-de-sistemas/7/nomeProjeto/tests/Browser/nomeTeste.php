<?php

namespace Tests\Browser;

use Illuminate\Foundation\Testing\DatabaseMigrations;
use Laravel\Dusk\Browser;
use Tests\DuskTestCase;

class nomeTeste extends DuskTestCase
{
    public function testaPalavraExistente(): void
    {
        $this->browse(function (Browser $browser) {
            
            /** Ação */
            $browser->visit('/')
            
            /** Verificação */
            ->assertSee('Laravel');
        });
    }
}